package characters;

import javafx.scene.image.Image;
import java.util.ArrayList;

import passwords.Password;
import abilities.*;
import java.util.Random;

public class Player extends Character {
    private Image[] boyIdle = new Image[] {
            new Image("BoySprites/Idle(1).png"),
            new Image("BoySprites/Idle(2).png"),
            new Image("BoySprites/Idle(3).png"),
            new Image("BoySprites/Idle(4).png"),
            new Image("BoySprites/Idle(5).png"),
            new Image("BoySprites/Idle(6).png"),
            new Image("BoySprites/Idle(7).png"),
            new Image("BoySprites/Idle(8).png"),
            new Image("BoySprites/Idle(9).png"),
            new Image("BoySprites/Idle(10).png"),
            new Image("BoySprites/Idle(11).png"),
            new Image("BoySprites/Idle(12).png"),
            new Image("BoySprites/Idle(13).png")
    };

    private ArrayList<Password> passwordManager = new ArrayList<>();
    private Password equippedPassword = new Password("Default");

    public Player() {
        super();
        this.setIdleFrames(boyIdle);
        this.setImage(this.getIdleFrames()[0]);
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
                System.out.println(this.getName() + " has learned FireWall!");
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
