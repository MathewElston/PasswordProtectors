package abilities;
import passwords.Password;
import characters.Character;
import characters.Player;

public class BruteForce extends Ability { 
    public BruteForce(int power) {
        super("Brute Force", "Use alogirithms to crack the user's password", power);
    }

    @Override
    public void use(Character target) {
        Password targetPassword  = ((Player)target).getEquippedPassword();
        if (targetPassword.checkPasswordStrength() < 5) {
            target.takeDamage(power*2);
        } else {
            target.takeDamage(power/2);
        }
    }
}