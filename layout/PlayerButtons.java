package layout;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class PlayerButtons extends GridPane {
    Button attackButton = new Button("Attack");
    Button abillityButton = new Button("Ability");
    Button infoButton = new Button("Info");
    Button passwordButton = new Button("Passwords");

    public PlayerButtons() {
        super();

    }

    public void setAttackButton(Button attackButton) {
        this.attackButton = attackButton;
    }

    public Button getAttackButton() {
        return attackButton;
    }

    public void setAbillityButton(Button abillityButton) {
        this.abillityButton = abillityButton;
    }

    public Button getAbillityButton() {
        return abillityButton;
    }

    public void setInfoButton(Button infoButton) {
        this.infoButton = infoButton;
    }

    public Button getInfoButton() {
        return infoButton;
    }

    public void setUpdatePassword(Button updatePassword) {
        this.passwordButton = updatePassword;
    }

    public Button getUpdatePassword() {
        return passwordButton;
    }
}
