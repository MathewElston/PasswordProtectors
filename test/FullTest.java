package test;

import characters.Character;
import characters.Hacker;
import characters.Player;
import game_loop.Animation;
import game_loop.GameState;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import layout.PassManagerBox;
import scenes.BattleScene;

public class FullTest extends Application {
    Character player = new Player();
    Character enemy = new Hacker();
    long previousFrame = 0;
    int targetFPS = 30;
    int targetMS = 1000 / targetFPS;
    BattleScene battleScene = new BattleScene(player, enemy);
    Animation animation = new Animation(player, enemy);
    GameState gameState = new GameState(battleScene);
    PassManagerBox passManagerBox = new PassManagerBox(player);

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

        primaryStage.setScene(battleScene);
        timer.start();
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
