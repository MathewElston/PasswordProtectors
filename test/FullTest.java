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
import layout.PassPhraseList;
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
        battleScene.getBattleScreen().getHud().getPlayerButtons().getPasswordButton().setOnAction(event -> {
            primaryStage.setScene(passManagerScene);
            timer.start();
        });
        passManagerScene.getPassBox().getPasswordManagerButtons().getAddButton().setOnAction(event -> {
            String randomString = "";
            Random random = new Random(System.nanoTime());
            PassPhraseList passPhraseList = passManagerScene.getPassBox().getPassPhraseList();
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

        // info scene
        battleScene.getBattleScreen().getHud().getPlayerButtons().getInfoButton().setOnAction(event ->

        {
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
