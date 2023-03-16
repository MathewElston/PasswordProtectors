package characters;

import javafx.scene.image.Image;
import java.util.ArrayList;

import passwords.Password;
import abilities.*;
import java.util.Random;

public class Player extends Character {
    private ArrayList<Password> passwordManager = new ArrayList<>();
    private Password equippedPassword = new Password("Default");

    public Player() {
        super();

    }

    public Player(Image[] frames) {
        super(frames);
    }

    public void takeTurn(Character target) {
        // implmenet turn based combat

    }

    @Override
    public void levelUp() {
        super.levelUp();
        switch (this.getLevel()) {
            case 2:
                this.learnAbility(new FireWall(2));
                break;
            default:
                break;
        }
    }

    @Override
    public void defeated() {
        // lose game
    }

    @Override
    public void attack(Character target) {
        int passwordStrength = this.getEquippedPassword().checkPasswordStrength();
        double passwordModifier = passwordStrength / 5.0;
        Random random = new Random(System.currentTimeMillis());
        // 80% to 100% of damage
        double damageModifier = 0.8 + (0.2 * random.nextDouble());
        int damage = (int) (this.getAttack() * passwordModifier * damageModifier - target.getDefense());
        target.takeDamage(damage);

        if (target.checkDefeat()) {
            System.out.println(this.getName() + " gained: " + target.getExperienceWorth() + " exp!");
            this.gainExp(target.getExperienceWorth());
        }
    }

    public void addPassword(String password) {
        this.passwordManager.add(new Password(password));
    }

    public void removePassword(int index) {
        this.passwordManager.remove(index);
    }

    public void setEquippedPassword(Password equippedPassword) {
        this.equippedPassword = equippedPassword;
    }

    public Password getEquippedPassword() {
        return equippedPassword;
    }

    public ArrayList<Password> getPasswordManager() {
        return passwordManager;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
