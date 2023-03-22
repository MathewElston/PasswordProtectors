package game_loop;

import characters.Character;
import javafx.scene.control.ProgressBar;
import layout.BattleFields;
import scenes.BattleScene;

public class GameState {

    private BattleScene battleScene;
    private ProgressBar playerProgressBar;
    private ProgressBar enemyProgressBar;
    double timerSpeed = 500.0;

    public GameState(BattleScene battleScene) {
        this.battleScene = battleScene;
    }

    private void updatePlayerProgress(Character player) {
        playerProgressBar = battleScene.getBattleScreen().getHud().getFields().getPlayerProgressBar();
        double playerSpeed = (double) player.getSpeed() / timerSpeed;
        double playerProgress = playerProgressBar.getProgress();
        playerProgress += playerSpeed;
        playerProgressBar.setProgress(playerProgress);
        if (playerProgress >= 0 && playerProgress < 0.33) {
            playerProgressBar.setStyle("-fx-accent: rgb(255, 0, 51);");
        } else if (playerProgress >= 0.33 && playerProgress < 1) {
            playerProgressBar.setStyle("-fx-accent: rgb(255, 204, 0);");
            /*
             * } else if (playerProgress >= 1) {
             * if (!turnQueue.contains(player)) {
             * turnQueue.add(player);
             * }
             */
        } else {
            playerProgressBar.setStyle("-fx-accent: rgb(0, 204, 102);");
        }
    }

    private void updateEnemyProgress(Character enemy) {
        enemyProgressBar = battleScene.getBattleScreen().getHud().getFields().getEnemyProgressBar();
        double enemySpeed = (double) enemy.getSpeed() / timerSpeed;
        double enemyProgress = enemyProgressBar.getProgress();
        enemyProgress += enemySpeed;
        enemyProgressBar.setProgress(enemyProgress);
        if (enemyProgress >= 0 && enemyProgress < 0.33) {
            enemyProgressBar.setStyle("-fx-accent: rgb(255, 0, 51);");
        } else if (enemyProgress >= 0.33 && enemyProgress < 1) {
            enemyProgressBar.setStyle("-fx-accent: rgb(255, 204, 0);");
            /*
             * } else if (enemyProgress >= 1) {
             * if (!turnQueue.contains(enemy)) {
             * turnQueue.add(enemy);
             * }
             */

        } else {
            enemyProgressBar.setStyle("-fx-accent: rgb(0, 204, 102);");
        }
    }

    public void update(Character player, Character enemy) {
        BattleFields fields = battleScene.getBattleScreen().getHud().getFields();

        fields.getPlayerNameLabel().setText(player.getName());
        fields.getPlayerHealthLabel().setText(player.getHealth() + " / " + player.getMaxHealth());
        fields.getPlayerAPLabel().setText(player.getAbilityPoints() + " / " + player.getAbilityPoints());

        fields.getEnemyNameLabel().setText(enemy.getName());
        fields.getEnemyHealthLabel().setText(enemy.getHealth() + " / " + enemy.getMaxHealth());
        fields.getEnemyAPLabel().setText(enemy.getAbilityPoints() + " / " + enemy.getAbilityPoints());
        updatePlayerProgress(player);
        updateEnemyProgress(enemy);
    }

}
