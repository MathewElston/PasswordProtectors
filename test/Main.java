package test;

import characters.Character;
import characters.Hacker;
import characters.Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import layout.BattleFields;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Character player = new Player();
        Character enemy = new Hacker();
        BattleFields battle = new BattleFields(player, enemy);
        Scene scene = new Scene(battle);

        stage.setScene(scene);
        stage.show();
        

    }

    public static void main(String[] args) {
        launch(args);
    }

}
