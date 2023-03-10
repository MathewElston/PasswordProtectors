package characters;
import javafx.scene.image.Image;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

public class Hacker extends Character {
    FadeTransition fadeTransition;

    public Hacker() {
        super();
    }
    public Hacker(Image[] frames) {
        super(frames);
        fadeTransition = new FadeTransition(Duration.seconds(3), this);
    }
    public void takeTurn() {
        // implement NPC logic.
    }
    public void defeated() {
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.play();
    }
}
