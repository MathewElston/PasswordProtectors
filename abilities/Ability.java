package abilities;

import characters.Character;

public abstract class Ability {
    String name;
    String description;
    int power;

    public Ability() {

    }

    public Ability(String name, String description, int power) {
        this.name = name;
        this.description = description;
        this.power = power;
    }

    // ability items need to have a use function
    abstract public void use(Character target);

    // setters and getters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
