package characters;

import javafx.scene.image.Image;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

public class Hacker extends Character {
    FadeTransition fadeTransition;
    private Image[] hackerIdle = new Image[] {
            new Image("RobotSprites/Idle(1).png"),
            new Image("RobotSprites/Idle(2).png"),
            new Image("RobotSprites/Idle(3).png"),
            new Image("RobotSprites/Idle(4).png"),
            new Image("RobotSprites/Idle(5).png"),
            new Image("RobotSprites/Idle(6).png"),
            new Image("RobotSprites/Idle(7).png"),
            new Image("RobotSprites/Idle(8).png"),
            new Image("RobotSprites/Idle(9).png"),
            new Image("RobotSprites/Idle(10).png")
    };

    public Hacker() {
        super();
        this.setIdleFrames(hackerIdle);
        this.setImage(this.getIdleFrames()[0]);
        fadeTransition = new FadeTransition(Duration.seconds(3), this);
    }

    @Override
    public void takeTurn(Character player) {
        this.attack(player);
    }

    public void defeated() {
        if (this.isVisible()) {
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.0);
            fadeTransition.play();
            this.setVisible(false);
        }
    }
}
