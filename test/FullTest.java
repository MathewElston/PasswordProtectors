package test;

import java.util.Random;

import characters.Character;
import characters.Hacker;
import characters.Player;
import game_loop.Animation;
import game_loop.GameState;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import layout.PassManagerBox;
import layout.PassPhraseList;
import layout.PasswordManagerButtons;
import layout.PasswordStrengthBox;
import layout.PlayerButtons;
import passwords.Password;
import scenes.BattleScene;
import scenes.InfoScene;
import scenes.PassManagerScene;
import scenes.StartMenuScene;

public class FullTest extends Application {
    Character player = new Player();
    Character enemy = new Hacker();
    long previousFrame = 0;
    int targetFPS = 30;
    int targetMS = 1000 / targetFPS;
    StartMenuScene startMenu = new StartMenuScene(400, 400);
    InfoScene infoScene = new InfoScene(400, 400);
    BattleScene battleScene = new BattleScene(player, enemy);
    Animation animation = new Animation(player, enemy);
    GameState gameState = new GameState(battleScene);
    PassManagerScene passManagerScene = new PassManagerScene(player);

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long timeStamp) {
                long now = System.currentTimeMillis();
                if (now - previousFrame > targetMS) {
                    animation.update();
                    gameState.update(player, enemy);
                    previousFrame = now;
                }
            }
        };

        // start scene
        primaryStage.setScene(startMenu);
        startMenu.getStartMenu().getStartButton().setOnAction(event -> {
            primaryStage.setScene(battleScene);
            timer.start();
        });
        // password manager scene
        PasswordManagerButtons passwordManagerButtons = passManagerScene.getPassBox().getPasswordManagerButtons();
        PassPhraseList passPhraseList = passManagerScene.getPassBox().getPassPhraseList();
        PlayerButtons playerButtons = battleScene.getBattleScreen().getHud().getPlayerButtons();

        playerButtons.getPasswordButton().setOnAction(event -> {
            primaryStage.setScene(passManagerScene);
            timer.start();
        });

        passwordManagerButtons.getAddButton().setOnAction(event -> {
            if (passPhraseList.getWordPhraseListView().getSelectionModel().getSelectedItem() != null
                    && passPhraseList.getDigitPhraseListView().getSelectionModel().getSelectedItem() != null
                    && passPhraseList.getSpecialCharPhraseListView().getSelectionModel().getSelectedItem() != null) {
                String fullString = "";
                fullString += passPhraseList.getWordPhraseListView().getSelectionModel().getSelectedItem();
                fullString += passPhraseList.getDigitPhraseListView().getSelectionModel().getSelectedItem();
                fullString += passPhraseList.getSpecialCharPhraseListView().getSelectionModel().getSelectedItem();
                ((Player) player).addPassword(fullString);
                passPhraseList.getPasswordListView().getItems().add(
                        ((Player) player).getPasswordManager().get(((Player) player).getPasswordManager().size() - 1));
            }
        });

        passwordManagerButtons.getRemoveButton().setOnAction(event -> {
            if (passPhraseList.getPasswordListView().getSelectionModel().getSelectedItem() != null) {
                int index = passPhraseList.getPasswordListView().getSelectionModel().getSelectedIndex();
                ((Player) player).removePassword(index);
                passPhraseList.getPasswordListView().getItems().remove(index);
            }
        });

        passwordManagerButtons.getRandomButton().setOnAction(event -> {
            String randomString = "";
            Random random = new Random(System.nanoTime());
            int wordPhraseIndex = random.nextInt(passPhraseList.getWordPhraseListView().getItems().size());
            int digitPhraseIndex = random.nextInt(passPhraseList.getDigitPhraseListView().getItems().size());
            int specialCharPhraseIndex = random
                    .nextInt(passPhraseList.getSpecialCharPhraseListView().getItems().size());
            randomString += passPhraseList.getWordPhraseListView().getItems().get(wordPhraseIndex);
            randomString += passPhraseList.getDigitPhraseListView().getItems().get(digitPhraseIndex);
            randomString += passPhraseList.getSpecialCharPhraseListView().getItems().get(specialCharPhraseIndex);
            ((Player) player).addPassword(randomString);
            passPhraseList.getPasswordListView().getItems()
                    .add(((Player) player).getPasswordManager().get(((Player) player).getPasswordManager().size() - 1));
        });

        passwordManagerButtons.getCloseButton().setOnAction(event -> {
            primaryStage.setScene(battleScene);
            timer.start();
        });

        PasswordStrengthBox strengthBox = battleScene.getBattleScreen().getHud().getStrengthBox();

        passwordManagerButtons.getEquipButton().setOnAction(event -> {
            if ((passPhraseList.getPasswordListView().getSelectionModel() != null)) {
                ((Player) player).setEquippedPassword(
                        passPhraseList.getPasswordListView().getSelectionModel().getSelectedItem());
                passwordManagerButtons.getCurrentlyEquipped()
                        .setText(((Player) player).getEquippedPassword().getValue());
                strengthBox.getStrengthBar()
                        .setProgress(((Player) player).getEquippedPassword().checkPasswordStrength() / 5);
                if (strengthBox.getStrengthBar().getProgress() < 0.25) {
                    strengthBox.getStrengthBar().setStyle("-fx-accent: red;");
                    strengthBox.getPasswordStrengthLabel().setStyle("-fx-text-fill: rgb(229, 57, 53);");
                    strengthBox.getPasswordStrengthLabel().setText("WEAK");
                } else if (strengthBox.getStrengthBar().getProgress() >= 0.25
                        && strengthBox.getStrengthBar().getProgress() < .80) {
                    strengthBox.getStrengthBar().setStyle("-fx-accent: yellow;");
                    strengthBox.getPasswordStrengthLabel().setStyle("-fx-text-fill: rgb(255, 185, 0);");
                    strengthBox.getPasswordStrengthLabel().setText("MEDIUM");
                } else if (strengthBox.getStrengthBar().getProgress() >= 0.80) {
                    strengthBox.getStrengthBar().setStyle("-fx-accent: green;");
                    strengthBox.getPasswordStrengthLabel().setStyle("-fx-text-fill: rgb(139, 195, 74);");
                    strengthBox.getPasswordStrengthLabel().setText("STRONG");
                }
            }
        });

        // info scene
        playerButtons.getInfoButton().setOnAction(event -> {
            primaryStage.setScene(infoScene);
            timer.stop();

        });

        infoScene.getInfoBox().getBackButton().setOnAction(event -> {
            primaryStage.setScene(battleScene);
            timer.start();
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
