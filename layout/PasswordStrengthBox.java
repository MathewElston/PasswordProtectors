package layout;

import characters.Character;
import characters.Player;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class PasswordStrengthBox extends VBox {
    private Label strengthHeader = new Label("Password Strength");
    private ProgressBar strengthBar = new ProgressBar(0);
    private Label passwordStrengthLabel = new Label("Default");
    private Node[] nodeList = {
            strengthHeader, strengthBar, passwordStrengthLabel
    };
    private int passwordPower;

    public PasswordStrengthBox(Character player) {
        super();
        strengthHeader.setPrefWidth(100);
        strengthBar.setPrefWidth(100);
        strengthHeader.setPrefWidth(100);

        if (player instanceof Player) {
            passwordPower = ((Player) player).getEquippedPassword().checkPasswordStrength();
        } else {
            passwordPower = 0;
        }
        this.getChildren().addAll(strengthHeader, strengthBar, passwordStrengthLabel);

    }

    public Label getStrengthHeader() {
        return strengthHeader;
    }

    public void setStrengthHeader(Label strengthHeader) {
        this.strengthHeader = strengthHeader;
    }

    public ProgressBar getStrengthBar() {
        return strengthBar;
    }

    public void setStrengthBar(ProgressBar strengthBar) {
        this.strengthBar = strengthBar;
    }

    public Label getPasswordStrengthLabel() {
        return passwordStrengthLabel;
    }

    public void setPasswordStrengthLabel(Label passwordStrengthLabel) {
        this.passwordStrengthLabel = passwordStrengthLabel;
    }

    public int getPasswordPower() {
        return passwordPower;
    }

    public void setPasswordPower(int passwordPower) {
        this.passwordPower = passwordPower;
    }

    public Node[] getLabelList() {
        return nodeList;
    }

    public void setLabelList(Node[] labelList) {
        this.nodeList = labelList;
    }

}
