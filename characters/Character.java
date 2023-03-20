package characters;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import abilities.Ability;
import java.util.ArrayList;
import java.util.Random;

public abstract class Character extends ImageView {
    private Image[] idleFrames;
    private Image[] attackFrames;
    private Image[] currentAnimation;
    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;
    private int health;
    private int maxHealth;
    private int abilityPoints;
    private int maxAbilityPoints;
    private boolean isDefeated = false;
    private int experience = 0;
    private int requiredExp = 250;
    private int experienceWorth;
    ArrayList<Ability> abilities = new ArrayList<>();
    int currentFrame = 0;

    public Character() {
        super();
        this.level = 1;
        this.attack = 5;
        this.defense = 2;
        this.speed = 3;
        this.maxHealth = 200;
        this.health = this.maxHealth;
        this.experienceWorth += this.level * 100;
    }

    public Character(String name, int level, int attack, int defense, int speed, int maxHealth) {
        super();
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
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

    public void gainExp(int amount) {
        this.experience += amount;
        if (this.experience >= this.requiredExp) {
            this.levelUp();
        }
    }

    public void levelUp() {
        this.level += 1;
        this.experience = 0;
        this.requiredExp += 50;
        this.experienceWorth += 50;
        this.attack += 5;
        this.defense += 2;
        this.speed += 2;
        this.maxHealth += 50;
        this.health += 50;
        System.out.println(this.name + " leveled up to " + this.level);
        System.out.println(this);

    }

    public void takeHeal(int amount) {
        this.health += 5;
    }

    public abstract void takeTurn(Character target);

    public void attack(Character target) {
        Random random = new Random(System.currentTimeMillis());
        // 80% to 100% of damage
        double damageModifier = 0.8 + (0.2 * random.nextDouble());
        int damage = (int) (this.attack * damageModifier) - target.getDefense();

        target.takeDamage(damage);

        if (target.checkDefeat()) {
            System.out.println(this.name + " gained: " + target.getExperienceWorth() + " exp!");
            this.gainExp(target.getExperienceWorth());
        }
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

    public int getExperienceWorth() {
        return experienceWorth;
    }

    public void setExperienceWorth(int experienceWorth) {
        this.experienceWorth = experienceWorth;
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

    public int getMaxAbilityPoints() {
        return maxAbilityPoints;
    }

    public void setMaxAbilityPoints(int maxAbilityPoints) {
        this.maxAbilityPoints = maxAbilityPoints;
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

    @Override
    public String toString() {
        return "Character :" +
                "\nName = '" + name + '\'' +
                "\nLevel = " + level +
                "\nAttack = " + attack +
                "\nDefense = " + defense +
                "\nSpeed = " + speed +
                "\nHealth = " + health +
                "\nMaxHealth = " + maxHealth +
                "\nAbilityPoints = " + abilityPoints;
    }
}
