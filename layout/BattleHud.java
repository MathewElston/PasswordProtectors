package layout;

import characters.Character;
import characters.Player;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class BattleHud extends HBox {
    private BattleFields fields;
    private PasswordStrengthBox strengthBox;
    private PlayerButtons playerButtons = new PlayerButtons();

    public BattleHud(Character player, Character enemy) {
        if (player instanceof Player) {
            playerButtons.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
            strengthBox = new PasswordStrengthBox(player);
            fields = new BattleFields(player, enemy);
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
            this.setAlignment(Pos.CENTER);
        } else {
            System.out.println("BattleHud does not have a player instance");
        }
    }

    public BattleFields getFields() {
        return fields;
    }

    public void setFieldsRef(BattleFields fields) {
        this.fields = fields;
    }

    public PasswordStrengthBox getStrengthBox() {
        return strengthBox;
    }

    public void setStrengthBoxRef(PasswordStrengthBox strengthBoxRef) {
        this.strengthBox = strengthBoxRef;
    }

    public void setFields(BattleFields fields) {
        this.fields = fields;
    }

    public void setStrengthBox(PasswordStrengthBox strengthBox) {
        this.strengthBox = strengthBox;
    }

    public PlayerButtons getPlayerButtons() {
        return playerButtons;
    }

    public void setPlayerButtons(PlayerButtons playerButtons) {
        this.playerButtons = playerButtons;
    }

    

}
