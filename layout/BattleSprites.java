package layout;

import characters.Character;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BattleSprites extends HBox {
    private VBox playerContainer = new VBox();
    private VBox enemyContainer = new VBox();

    public BattleSprites(Character player, Character enemy) {
        super();
        playerContainer.getChildren().add(player);
        enemyContainer.getChildren().add(enemy);
        this.getChildren().addAll(player, enemy);
        this.setStyle("-fx-background-image: url(cyberpunk_background.png);"
                + "-fx-background-size: cover;");
    }
}
