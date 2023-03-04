package test;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MenuBox extends Rectangle {
    private StackPane stackPane;

    public MenuBox(StackPane stackPane, double width, double height) {
        super(width,height);
        this.stackPane = stackPane;
        setWidth(stackPane.getWidth());
        setHeight(stackPane.getHeight());
        setFill(Color.WHITE);
        setOpacity(0.7);
        setMouseTransparent(false);
        stackPane.getChildren().add(this);
        setVisible(false);
    }

    public void show() {
        setVisible(true);
    }

    public void hide() {
        setVisible(false);
    }

    public StackPane getStackPane() {
        return stackPane;
    }
}
