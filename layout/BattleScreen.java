package layout;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import layout.BattleHud;
import layout.BattleFields;
import layout.BattleSprites;
import characters.Character;
import characters.Player;
import characters.Hacker;

public class BattleScreen extends VBox {
    private DialogueBox dialogue;
    private BattleSprites battleSprites;
    private BattleHud hud;

    public BattleScreen(Character player, Character enemy) {
        dialogue = new DialogueBox();
        battleSprites = new BattleSprites(player, enemy);
        hud = new BattleHud(player, enemy);

        this.getChildren().addAll(dialogue, battleSprites, hud);
        this.setAlignment(Pos.CENTER);
    }

    public DialogueBox getDialogue() {
        return dialogue;
    }

    public void setDialogue(DialogueBox dialogue) {
        this.dialogue = dialogue;
    }

    public BattleSprites getBattleSprites() {
        return battleSprites;
    }

    public void setBattleSprites(BattleSprites battleSpritesRef) {
        this.battleSprites = battleSpritesRef;
    }

    public BattleHud getHud() {
        return hud;
    }

    public void setHud(BattleHud hudRef) {
        this.hud = hudRef;
    }
}
