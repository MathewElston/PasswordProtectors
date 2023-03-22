package scenes;

import characters.Character;
import javafx.scene.Scene;
import layout.PassManagerBox;

public class PassManagerScene extends Scene {
    private PassManagerBox passBox;

    public PassManagerScene(Character player) {
        super(new PassManagerBox(player));
        passBox = (PassManagerBox) this.getRoot();
    }

    public PassManagerScene(Character player, double width, double height) {
        super(new PassManagerBox(player), width, height);
        passBox = (PassManagerBox) this.getRoot();
    }

    public PassManagerBox getPassBox() {
        return passBox;
    }

    public void setPassBox(PassManagerBox passBox) {
        this.passBox = passBox;
    }

}
