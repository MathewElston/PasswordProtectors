package test;

// sprites from https://www.gameart2d.com/the-boy---free-sprites.html

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.animation.AnimationTimer;

import characters.Player;
import characters.Hacker;

public class CharTest extends Application {
    Image[] boyIdleFrames = new Image[] {
        new Image("BoySprites/Idle(1).png"),
        new Image("BoySprites/Idle(2).png"),
        new Image("BoySprites/Idle(3).png"),
        new Image("BoySprites/Idle(4).png"),
        new Image("BoySprites/Idle(5).png"),
        new Image("BoySprites/Idle(6).png"),
        new Image("BoySprites/Idle(7).png"),
        new Image("BoySprites/Idle(8).png"),
        new Image("BoySprites/Idle(9).png"),
        new Image("BoySprites/Idle(10).png"),
        new Image("BoySprites/Idle(11).png"),
        new Image("BoySprites/Idle(12).png"),
        new Image("BoySprites/Idle(13).png")
    };
    Image[] hackerIdleFrames = new Image[] {
        new Image("RobotSprites/Idle(1).png"),
        new Image("RobotSprites/Idle(2).png"),
        new Image("RobotSprites/Idle(3).png"),
        new Image("RobotSprites/Idle(4).png"),
        new Image("RobotSprites/Idle(5).png"),
        new Image("RobotSprites/Idle(6).png"),
        new Image("RobotSprites/Idle(7).png"),
        new Image("RobotSprites/Idle(8).png"),
        new Image("RobotSprites/Idle(9).png"),
        new Image("RobotSprites/Idle(10).png")
    };

    Player player = new Player(boyIdleFrames);
    Hacker hacker = new Hacker(hackerIdleFrames);
    long previousFrame = 0;

    public void update(long timeStamp) {
        long now = System.currentTimeMillis();
        if (now - previousFrame > 35) {
            player.update();
            hacker.update();
            hacker.setScaleX(-1);
            previousFrame = now;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    Pane root = new Pane();
    HBox playerBox = new HBox();
    playerBox.getChildren().addAll(player,hacker);
    root.getChildren().add(playerBox);
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timeStamp) {
            update(timeStamp);
        }
    };

    timer.start();
    primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
