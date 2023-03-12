package characters;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import abilities.Ability;
import java.util.ArrayList;

public abstract class Character extends ImageView implements Comparable<Character> {
    String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;
    private int health;
    private int maxHealth;
    private int abilityPoints;
    private boolean isDefeated = false;
    ArrayList<Ability> abilities = new ArrayList<>();
    private Image[] idleFrames;
    private Image[] attackFrames;
    private Image[] currentAnimation;
    int currentFrame = 0;

    public Character() {
        super();
    }

    public Character(Image[] frames) {
        super(frames[0]);
        this.idleFrames = frames;
        this.level = 1;
        this.attack = 5;
        this.defense = 2;
        this.speed = 3;
        this.maxHealth = 200;
        this.health = this.maxHealth;

    }

    public Character(Image[] frames, String name, int level, int attack, int defense, int speed, int maxHealth) {
        super(frames[0]);
        this.idleFrames = frames;
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    // compare speeds to determine the turn order
    @Override
    public int compareTo(Character other) {
        return Integer.compare(this.speed, other.speed);
    }

    public abstract void defeated();

    // useAbility()
    public void takeDamage(int amount) {
        this.health -= amount;
        System.out.println(this.name + " took " + amount + " damage");
        if (this.health <= 0) {
            this.health = 0;
            this.isDefeated = true;
            this.defeated();
        }
    }

    public void takeHeal(int amount) {
        this.health += 5;
    }

    public abstract void takeTurn(Character target);

    public void attack(Character target) {
        target.takeDamage(this.attack);
    }

    public void animate(Image[] animationImages, int currentFrame) {
        this.setImage(animationImages[currentFrame]);
    }

    // update per frame
    public void update() {
        currentFrame++;
        if (this.currentFrame >= this.idleFrames.length) {
            currentFrame = 0;
        }
        animate(idleFrames, currentFrame);
    }

    public void increaseAttack(int amount) {
        this.attack += amount;
    }

    public void increaseDefense(int amount) {
        this.defense += amount;
    }

    public void increaseMaxHealth(int amount) {
        this.maxHealth += amount;
    }

    // geters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int atttack) {
        this.attack = atttack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAbilities(ArrayList<Ability> abilities) {
        this.abilities = abilities;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public void learnAbility(Ability newAbility) {
        this.abilities.add(newAbility);
    }

    public int getAbilityPoints() {
        return abilityPoints;
    }

    public void setAbilityPoints(int abilityPoints) {
        this.abilityPoints = abilityPoints;
    }

    public void setDefeated(boolean isDefeated) {
        this.isDefeated = isDefeated;
    }

    public boolean checkDefeat() {
        return isDefeated;
    }

    public Image[] getIdleFrames() {
        return idleFrames;
    }

    public void setIdleFrames(Image[] idleFrames) {
        this.idleFrames = idleFrames;
    }

    public void setCurrentAnimation(Image[] currentAnimation) {
        this.currentAnimation = currentAnimation;
    }
}
