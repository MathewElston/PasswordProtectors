package characters;

import javafx.scene.image.Image;
import passwords.Password;
import java.util.ArrayList;

public class Player extends Character {
    private ArrayList<Password> passwordManager = new ArrayList<>();
    private Password equippedPassword = new Password("Default");
    private int experience = 0;
    private int requiredExp  = 250;

    public Player() {
        super();
        
    }
    public Player(Image[] frames) {
        super(frames);
    }

    public void takeTurn() {
        // implmenet turn based combat
        
    }
    public void defeated() {
        // lose game
    }
    @Override
    public void attack(Character target) {
        super.attack(target);
    }
    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
        this.experience = 0;
        this.requiredExp += 50;
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
