package scenes;

import javafx.scene.Scene;
import layout.BattleScreen;
import characters.Character;

public class BattleScene extends Scene {
    private BattleScreen battleScreen;

    public BattleScene(Character player, Character enemy) {
        super(new BattleScreen(player, enemy));
        battleScreen = (BattleScreen) this.getRoot();

    }

    
    public BattleScreen getBattleScreen() {
        return battleScreen;
    }


    public void setBattleScreen(BattleScreen battleScreen) {
        this.battleScreen = battleScreen;
    }
}
