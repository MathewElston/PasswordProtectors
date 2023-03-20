package test;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import layout.StartMenu;
import javafx.scene.paint.Color;
import javafx.stage.Popup;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.image.Image;

import scenes.StartMenuScene;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        try {
            StartMenuScene startScene = new StartMenuScene(800, 800);

            stage.setScene(startScene);
            stage.show();
            startScene.getStartMenu().getStartButton().setOnAction(event -> {
                System.out.println("Clicked!");

            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
