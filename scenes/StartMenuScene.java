package scenes;

import javafx.scene.Scene;
import layout.StartMenu;

public class StartMenuScene extends Scene {
    private StartMenu startMenu;

    public StartMenuScene(double width, double height) {
        super(new StartMenu(), width, height);
        startMenu = (StartMenu) this.getRoot();
    }

    public StartMenu getStartMenu() {
        return startMenu;
    }

}
