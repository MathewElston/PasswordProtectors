package layout;

import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import characters.Character;
import characters.Player;
import characters.Hacker;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class StartMenu extends VBox {
    private Text titleHeading = new Text("Password\nProtectors");
    private Button startButton = new Button("Start");
    private TextFlow textFlow = new TextFlow(titleHeading);

    public StartMenu() {
        this.getChildren().addAll(textFlow, startButton);
        this.getTextFlow().setTextAlignment(TextAlignment.CENTER);
        this.getTitleHeading().setFill(Color.rgb(255, 200, 0));
        this.getTextFlow().setStyle("-fx-font-size: 48px; -fx-font-weight: bold;");
        this.setAlignment(Pos.CENTER);

        this.getStartButton().setStyle("-fx-text-fill: rgb(0, 170, 255);");
        this.setAlignment(Pos.TOP_CENTER);
        this.setStyle("-fx-background-image: url(/assets/Title_Screen.jpg); -fx-background-size: cover;");
    }

    public TextFlow getTextFlow() {
        return textFlow;
    }

    public void setTextFlow(TextFlow textFlow) {
        this.textFlow = textFlow;
    }

    public void setTitleHeading(Text titleHeading) {
        this.titleHeading = titleHeading;
    }

    public Text getTitleHeading() {
        return titleHeading;
    }

    public Button getStartButton() {
        return startButton;
    }

    public void setStartButton(Button startButton) {
        this.startButton = startButton;
    }

}
