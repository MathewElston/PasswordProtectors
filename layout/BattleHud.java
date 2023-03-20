package layout;

import characters.Character;
import characters.Player;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class BattleHud extends HBox {

    public BattleHud(Character player, Character enemy) {
        if (player instanceof Player) {
            PlayerButtons playerButtons = new PlayerButtons();
            playerButtons.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
            PasswordStrengthBox strengthBox = new PasswordStrengthBox(player);
            BattleFields fields = new BattleFields(player, enemy);
            fields.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
            for (Node field : fields.getHeaderFields()) {
                if (field instanceof Label) {
                    field.setStyle("-fx-text-fill: white;");
                }
            }
            for (Node node : fields.getPlayerFields()) {
                if (node instanceof Label) {
                    node.setStyle("-fx-text-fill: white;");
                }
            }
            for (Node node : fields.getEnemyFields()) {
                if (node instanceof Label) {
                    node.setStyle("-fx-text-fill: white;");
                }
            }

            for (Node node : strengthBox.getNodeList()) {
                if (node instanceof Label) {
                    node.setStyle("-fx-text-fill: white;");
                }
            }
            this.setSpacing(10);
            this.getChildren().addAll(playerButtons, strengthBox, fields);
            this.setStyle("-fx-background-color:rgb(25,45,200,0.8);");
        } else {
            System.out.println("BattleHud does not have a player instance");
        }
    }

}
