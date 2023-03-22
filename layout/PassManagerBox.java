package layout;

import characters.Character;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;

public class PassManagerBox extends Pane {
    private PassPhraseList passPhraseList;
    private PasswordManagerButtons passwordManagerButtons;
    private Popup popup = new Popup();
    private VBox container = new VBox();

    public PassManagerBox(Character player) {
        super();
        this.passPhraseList = new PassPhraseList(player);
        this.passwordManagerButtons = new PasswordManagerButtons();
        this.passwordManagerButtons.setAlignment(Pos.CENTER);
        this.container.getChildren().addAll(passPhraseList, passwordManagerButtons);
        this.popup.getContent().add(container);
        this.getChildren().add(container);
        this.setStyle("-fx-background-color: white;");
    }

    public void show() {
        this.setVisible(true);
    }

    public void hide() {
        this.setVisible(false);
    }
}
