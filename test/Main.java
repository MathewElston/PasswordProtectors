package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Popup;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        // Create some controls to add to the menu

        Label label1 = new Label("Enter your name:");
        TextField textField1 = new TextField();
        Button button1 = new Button("OK");

        // Create a VBox to hold the controls
        VBox menuContent = new VBox(label1, textField1, button1);
        menuContent.setStyle("-fx-background-color: white; -fx-padding: 10px; -fx-spacing: 5px;");

        // Create a Popup and set its content to the VBox
        Popup popup = new Popup();
        popup.getContent().add(menuContent);

        // Create a button to show the menu
        Button menuButton = new Button("Menu");
        menuButton.setOnAction(event -> {
            popup.show(stage);
        });

        // Create a StackPane to hold the button and set it as the root node of the Scene
        StackPane root = new StackPane(menuButton);
        Scene scene = new Scene(root, 200, 200);
        stage.setScene(scene);
        stage.setTitle("Overlay Menu Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
