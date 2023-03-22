package scenes;

import javafx.scene.Scene;
import layout.InfoBox;

public class InfoScene extends Scene {
    InfoBox infoBox;

    public InfoScene() {
        super(new InfoBox());
        infoBox = (InfoBox) this.getRoot();
    }

    public InfoScene(double width, double height) {
        super(new InfoBox(), width, height);
        infoBox = (InfoBox) this.getRoot();
    }

    public InfoBox getInfoBox() {
        return infoBox;
    }

    public void setInfoBox(InfoBox infoBox) {
        this.infoBox = infoBox;
    }

}
