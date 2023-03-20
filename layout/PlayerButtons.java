package layout;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class PlayerButtons extends GridPane {
    private Button attackButton = new Button("Attack");
    private Button abillityButton = new Button("Ability");
    private Button infoButton = new Button("Info");
    private Button passwordButton = new Button("Passwords");
    private Node[] nodeList = {
        attackButton, abillityButton, infoButton, passwordButton
    };

    public PlayerButtons() {
        super();
        attackButton.setPrefWidth(100);
        abillityButton.setPrefWidth(100);
        infoButton.setPrefWidth(100);
        passwordButton.setPrefWidth(100);
        this.add(attackButton, 0, 0);
        this.add(abillityButton, 1, 0);
        this.add(infoButton, 0, 1);
        this.add(passwordButton, 1, 1);
        this.setHgap(10);
        this.setVgap(10);
    }

    public Button getPasswordButton() {
        return passwordButton;
    }

    public void setPasswordButton(Button passwordButton) {
        this.passwordButton = passwordButton;
    }

    public Node[] getButtonList() {
        return nodeList;
    }

    public void setButtonList(Node[] buttonList) {
        this.nodeList = buttonList;
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

    public Node[] getNodeList() {
        return nodeList;
    }

    public void setNodeList(Node[] nodeList) {
        this.nodeList = nodeList;
    }
    
}
