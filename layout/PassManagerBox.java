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
        this.passwordManagerButtons = new PasswordManagerButtons(player);
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

    public PassPhraseList getPassPhraseList() {
        return passPhraseList;
    }

    public void setPassPhraseList(PassPhraseList passPhraseList) {
        this.passPhraseList = passPhraseList;
    }

    public PasswordManagerButtons getPasswordManagerButtons() {
        return passwordManagerButtons;
    }

    public void setPasswordManagerButtons(PasswordManagerButtons passwordManagerButtons) {
        this.passwordManagerButtons = passwordManagerButtons;
    }

    public Popup getPopup() {
        return popup;
    }

    public void setPopup(Popup popup) {
        this.popup = popup;
    }

    public VBox getContainer() {
        return container;
    }

    public void setContainer(VBox container) {
        this.container = container;
    }
}
