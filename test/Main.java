package test;

import characters.Character;
import characters.Hacker;
import characters.Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import layout.BattleScreen;
import layout.BattleSprites;
import scenes.BattleScene;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Character player = new Player();
        player.setName("Player");
        Character enemy = new Hacker();
        enemy.setName("Enemy");

        BattleScene battleScene = new BattleScene(player, enemy);

        battleScene.getBattleScreen().getHud().getFields().getEnemyFields();
        stage.setScene(battleScene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
