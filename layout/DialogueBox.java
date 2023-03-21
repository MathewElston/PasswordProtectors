package layout;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DialogueBox extends VBox {
    private Label dialogue = new Label();

    public DialogueBox(String text) {
        dialogue = new Label();
        dialogue.setText(text);
        dialogue.setStyle("-fx-text-fill: white;");
        this.getChildren().add(dialogue);
        this.setStyle("-fx-background-color:rgb(25,45,200,0.8);");
    }

    public DialogueBox() {
        dialogue.setStyle("-fx-text-fill: white;");
        this.getChildren().add(dialogue);
        this.setStyle("-fx-background-color:rgb(25,45,200,0.8);");
    }

    public Label getDialogue() {
        return dialogue;
    }

    public void setDialogue(Label dialogue) {
        this.dialogue = dialogue;
    }

}
