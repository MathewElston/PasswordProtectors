package test;

import characters.Character;
import characters.Hacker;
import characters.Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import layout.BattleHud;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Character player = new Player();
        Character enemy = new Hacker();
        BattleHud box = new BattleHud(player, enemy);
        Scene scene = new Scene(box);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
