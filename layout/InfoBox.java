package layout;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class InfoBox extends VBox {
    private String headerString = "Welcome to Password Protectors!";
    private String stringBody = "Your goal is to defeat the evil hackbots who are trying to steal your passwords. Create new strong passwords to keep damaging your opponent! Level up and get new abilities to defeat the the super mega hackbot that's creating an endless supply of hackbots. A strong password is at least 12 characters long and includes a mix of uppercase and lowercase letters, numbers, and special characters like !,@,#. Your password strength will determine how much damage you can do to the hackbots. Do you have what it takes to save world from compromised passwords?";
    private TextFlow textFlow = new TextFlow();
    private TextFlow headerFlow = new TextFlow();
    private Button backButton = new Button("Back");

    public InfoBox() {
        Text header = new Text(headerString);
        header.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        headerFlow.getChildren().add(header);
        headerFlow.setLineSpacing(10);
        headerFlow.setPadding(new Insets(10));
        Text info = new Text(stringBody);
        textFlow.getChildren().addAll(info);
        textFlow.setLineSpacing(10);
        textFlow.setPadding(new Insets(10));
        this.getChildren().addAll(headerFlow, textFlow, backButton);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
    }

    public String getHeaderString() {
        return headerString;
    }

    public void setHeaderString(String headerString) {
        this.headerString = headerString;
    }

    public String getStringBody() {
        return stringBody;
    }

    public void setStringBody(String stringBody) {
        this.stringBody = stringBody;
    }

    public TextFlow getTextFlow() {
        return textFlow;
    }

    public void setTextFlow(TextFlow textFlow) {
        this.textFlow = textFlow;
    }

    public TextFlow getHeaderFlow() {
        return headerFlow;
    }

    public void setHeaderFlow(TextFlow headerFlow) {
        this.headerFlow = headerFlow;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }
}
