package abilities;

import characters.Character;

public class FireWall extends Ability {

    public FireWall(int power) {
        super("Fire Wall", "Use advanced security techniques to save yourself from invading hackers. Boosts your Attack and Defense.", power);
    }

    @Override
    public void use(Character target) {
        target.increaseAttack(power);
        target.increaseDefense(power);

    }
    
}
