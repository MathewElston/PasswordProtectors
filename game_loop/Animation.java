package game_loop;

import characters.Character;

public class Animation {
    private Character player;
    private Character enemy;

    public Animation(Character player, Character enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void update() {
        player.update();
        enemy.update();
        enemy.setScaleX(-1);

    }
}
