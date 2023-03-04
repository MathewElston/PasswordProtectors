package abilities;
import passwords.Password;
import characters.Character;
import characters.Player;
import java.util.Random;

public class Phishing extends Ability { 
    public Phishing() {
        super();
    }
    @Override
    public void use(Character target) {
        Random random = new Random(System.nanoTime());
        Password targetPassword = ((Player) target).getEquippedPassword();
        Password hackedPassword = new Password("Thank you for your password");
        int strength = targetPassword.checkPasswordStrength();

        int chance = (int) ((float) strength / 4 * 100);
        int val = random.nextInt(101);

        if (val <= chance) {
            ((Player) target).setEquippedPassword(hackedPassword);
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
    }
}