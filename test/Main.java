package test;

import characters.Character;
import characters.Hacker;
import characters.Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import layout.BattleSprites;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Character player = new Player();
        player.setName("Player");
        Character enemy = new Hacker();
        enemy.setName("Enemy");
        BattleSprites box = new BattleSprites(player, enemy);
        Scene scene = new Scene(box);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
