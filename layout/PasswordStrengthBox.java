package layout;

import characters.Character;
import characters.Player;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class PasswordStrengthBox extends VBox {
    private Label strengthHeader = new Label("Password Strength");
    private ProgressBar strengthBar = new ProgressBar(0);
    private Label passwordStrengthLabel = new Label();
    private int passwordPower;

    public PasswordStrengthBox(Character player) {
        super();
        if (player instanceof Player) {
            passwordPower = ((Player) player).getEquippedPassword().checkPasswordStrength();
        } else {
            passwordPower = 0;
        }

    }

}
