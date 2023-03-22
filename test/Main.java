package test;

import characters.Character;
import characters.Hacker;
import characters.Player;
import game_loop.Animation;
import game_loop.GameState;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import layout.PassManagerBox;
import layout.PassPhraseList;
import layout.PasswordManagerButtons;
import scenes.BattleScene;

public class Main extends Application {

    Character player = new Player();
    Character enemy = new Hacker();
    long previousFrame = 0;
    int targetFPS = 30;
    int targetMS = 1000 / targetFPS;
    BattleScene battleScene = new BattleScene(player, enemy);
    Animation animation = new Animation(player, enemy);
    GameState gameState = new GameState(battleScene);
    PassPhraseList phraseList = new PassPhraseList(player);
    PasswordManagerButtons passButtons = new PasswordManagerButtons();

    @Override
    public void start(Stage stage) {
        player.setName("Player");
        enemy.setName("Billy");
        enemy.setSpeed(5);
        player.setSpeed(10);
        ((Player) player).addPassword("addPassword");
        ((Player) player).addPassword("2Password");

        PassManagerBox passManagerBox = new PassManagerBox(player);
        Pane root = new Pane();
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

        Scene testScene = new Scene(passManagerBox);
        passManagerBox.hide();
        stage.setScene(testScene);
        timer.start();
        stage.show();
    }

    /*
     * public void update(Character player, Character enemy, long timeStamp) {
     * long now = System.currentTimeMillis();
     * if (now - previousFrame > targetMS) {
     * if (!player.checkDefeat()) {
     * player.update();
     * }
     * if (!enemy.checkDefeat()) {
     * enemy.update();
     * enemy.setScaleX(-1);
     * }
     * previousFrame = now;
     * }
     * }
     */

    public static void main(String[] args) {
        launch(args);
    }
}
