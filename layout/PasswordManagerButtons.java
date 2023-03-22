package layout;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class PasswordManagerButtons extends GridPane {
    private Button addButton = new Button("Add");
    private Button removeButton = new Button("Remove");
    private Button randomButton = new Button("Randomize");
    private Button equipButton = new Button("Equip");
    private Button saveButton = new Button("Save");
    private Button loadButton = new Button("Load");
    private Button closeButton = new Button("Close");

    public PasswordManagerButtons() {
        super();
        addButton.setPrefWidth(100);
        removeButton.setPrefWidth(100);
        randomButton.setPrefWidth(100);
        equipButton.setPrefWidth(100);
        saveButton.setPrefWidth(100);
        loadButton.setPrefWidth(100);
        closeButton.setPrefWidth(100);

        this.add(addButton, 0, 0);
        this.add(removeButton, 0, 1);
        this.add(randomButton, 0, 2);
        this.add(equipButton, 1, 1);
        this.add(saveButton, 2, 0);
        this.add(loadButton, 2, 1);
        this.add(closeButton, 2, 2);

        this.setHgap(10);
        this.setVgap(10);

    }

    public Button getAddButton() {
        return addButton;
    }

    public void setAddButton(Button addButton) {
        this.addButton = addButton;
    }

    public Button getRandomButton() {
        return randomButton;
    }

    public void setRandomButton(Button randomButton) {
        this.randomButton = randomButton;
    }

    public Button getRemoveButton() {
        return removeButton;
    }

    public void setRemoveButton(Button removeButton) {
        this.removeButton = removeButton;
    }

    public Button getEquipButton() {
        return equipButton;
    }

    public void setEquipButton(Button equipButton) {
        this.equipButton = equipButton;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(Button saveButton) {
        this.saveButton = saveButton;
    }

    public Button getLoadButton() {
        return loadButton;
    }

    public void setLoadButton(Button loadButton) {
        this.loadButton = loadButton;
    }

    public Button getCloseButton() {
        return closeButton;
    }

    public void setCloseButton(Button closeButton) {
        this.closeButton = closeButton;
    }

}
