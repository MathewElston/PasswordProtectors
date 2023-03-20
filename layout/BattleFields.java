package layout;

import characters.Character;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;

public class BattleFields extends GridPane {
    private Label nameLabel = new Label("Name");
    private Label healthLabel = new Label("Health");
    private Label abilityLabel = new Label("Ability");
    private Label queueLabel = new Label("Queue");
    private Node[] headerFields = {
            nameLabel, healthLabel, abilityLabel, queueLabel
    };

    private Label playerNameLabel = new Label();
    private Label playerHealthLabel = new Label();
    private Label playerAPLabel = new Label();
    private ProgressBar playerProgressBar = new ProgressBar(0);
    private Node[] playerFields = {
            playerNameLabel, playerHealthLabel, playerAPLabel, playerProgressBar
    };

    private Label enemyNameLabel = new Label();
    private Label enemyHealthLabel = new Label();
    private Label enemyAPLabel = new Label();
    private ProgressBar enemyProgressBar = new ProgressBar(0);
    private Node[] enemyFields = {
            enemyNameLabel, enemyHealthLabel, enemyAPLabel, enemyProgressBar
    };

    public BattleFields(Character player, Character enemy) {
        super();
        playerNameLabel.setText(player.getName());
        playerHealthLabel.setText(player.getHealth() + " / " + player.getMaxHealth());
        playerAPLabel.setText(player.getAbilities() + " / " + player.getMaxAbilityPoints());

        enemyNameLabel.setText(enemy.getName());
        enemyHealthLabel.setText(enemy.getHealth() + " / " + enemy.getMaxHealth());
        enemyAPLabel.setText(enemy.getAbilities() + " / " + enemy.getMaxAbilityPoints());

        nameLabel.setPrefWidth(100);
        healthLabel.setPrefWidth(100);
        abilityLabel.setPrefWidth(100);
        queueLabel.setPrefWidth(100);

        playerNameLabel.setPrefWidth(100);
        playerHealthLabel.setPrefWidth(100);
        playerAPLabel.setPrefWidth(100);
        playerProgressBar.setPrefWidth(100);

        enemyNameLabel.setPrefWidth(100);
        enemyHealthLabel.setPrefWidth(100);
        enemyAPLabel.setPrefWidth(100);
        enemyProgressBar.setPrefWidth(100);

        for (int i = 0; i < headerFields.length; i++) {
            this.add(headerFields[i], i, 0);
            this.add(playerFields[i], i, 1);
            this.add(enemyFields[i], i, 2);

        }
    }

    public Label getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(Label nameLabel) {
        this.nameLabel = nameLabel;
    }

    public Label getHealthLabel() {
        return healthLabel;
    }

    public void setHealthLabel(Label healthLabel) {
        this.healthLabel = healthLabel;
    }

    public Label getAbilityLabel() {
        return abilityLabel;
    }

    public void setAbilityLabel(Label abilityLabel) {
        this.abilityLabel = abilityLabel;
    }

    public Label getQueueLabel() {
        return queueLabel;
    }

    public void setQueueLabel(Label queueLabel) {
        this.queueLabel = queueLabel;
    }

    public Node[] getHeaderFields() {
        return headerFields;
    }

    public void setHeaderFields(Node[] headerFields) {
        this.headerFields = headerFields;
    }

    public Label getPlayerNameLabel() {
        return playerNameLabel;
    }

    public void setPlayerNameLabel(Label playerNameLabel) {
        this.playerNameLabel = playerNameLabel;
    }

    public Label getPlayerHealthLabel() {
        return playerHealthLabel;
    }

    public void setPlayerHealthLabel(Label playerHealthLabel) {
        this.playerHealthLabel = playerHealthLabel;
    }

    public Label getPlayerAPLabel() {
        return playerAPLabel;
    }

    public void setPlayerAPLabel(Label playerAPLabel) {
        this.playerAPLabel = playerAPLabel;
    }

    public ProgressBar getPlayerProgressBar() {
        return playerProgressBar;
    }

    public void setPlayerProgressBar(ProgressBar playerProgressBar) {
        this.playerProgressBar = playerProgressBar;
    }

    public Node[] getPlayerFields() {
        return playerFields;
    }

    public void setPlayerFields(Node[] playerFields) {
        this.playerFields = playerFields;
    }

    public Label getEnemyNameLabel() {
        return enemyNameLabel;
    }

    public void setEnemyNameLabel(Label enemyNameLabel) {
        this.enemyNameLabel = enemyNameLabel;
    }

    public Label getEnemyHealthLabel() {
        return enemyHealthLabel;
    }

    public void setEnemyHealthLabel(Label enemyHealthLabel) {
        this.enemyHealthLabel = enemyHealthLabel;
    }

    public Label getEnemyAPLabel() {
        return enemyAPLabel;
    }

    public void setEnemyAPLabel(Label enemyAPLabel) {
        this.enemyAPLabel = enemyAPLabel;
    }

    public ProgressBar getEnemyProgressBar() {
        return enemyProgressBar;
    }

    public void setEnemyProgressBar(ProgressBar enemyProgressBar) {
        this.enemyProgressBar = enemyProgressBar;
    }

    public Node[] getEnemyFields() {
        return enemyFields;
    }

    public void setEnemyFields(Node[] enemyFields) {
        this.enemyFields = enemyFields;
    }

}
