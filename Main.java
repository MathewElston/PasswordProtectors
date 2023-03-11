import java.awt.Color;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.Scene;

import characters.Player;
import characters.Character;
import characters.Hacker;
import passwords.Password;
import battle.BattleState;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.util.Duration;

public class Main extends Application {
    BattleState battleState;


    // set up idle sprites and animation
    Image[] boyIdleFrames = new Image[] {
        new Image("BoySprites/Idle(1).png"),
        new Image("BoySprites/Idle(2).png"),
        new Image("BoySprites/Idle(3).png"),
        new Image("BoySprites/Idle(4).png"),
        new Image("BoySprites/Idle(5).png"),
        new Image("BoySprites/Idle(6).png"),
        new Image("BoySprites/Idle(7).png"),
        new Image("BoySprites/Idle(8).png"),
        new Image("BoySprites/Idle(9).png"),
        new Image("BoySprites/Idle(10).png"),
        new Image("BoySprites/Idle(11).png"),
        new Image("BoySprites/Idle(12).png"),
        new Image("BoySprites/Idle(13).png")
    };
    Image[] hackerIdleFrames = new Image[] {
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
    // background image
    Image backgroundImage = new Image("cyberpunk_background.png");
    
    Character player = new Player(boyIdleFrames);
    Character hacker = new Hacker(hackerIdleFrames);
    long previousFrame = 0;
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timeStamp) {
            update(timeStamp);
        }
    };

    // main window control items
    Label nameLabel = new Label("Name");
    Label healthLabel = new Label("Health");
    Label abilityLabel = new Label("Ability");

    Label playerNameLabel = new Label(player.getName());
    Label playerHealthLabel = new Label(player.getHealth()+ "/ "+player.getMaxHealth());
    Label playerAPLabel = new Label(player.getAbilityPoints()+ "/ "+player.getAbilityPoints());

    Label hackerNameLabel = new Label();
    Label hackerHealthLabel = new Label();
    Label hackerAPLabel = new Label();

    Label dialogueLabel = new Label("");
    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), dialogueLabel);
    Label passwordStrengthLabel = new Label();
    Button attackButton = new Button("Attack");
    Button abilityButton = new Button("Ability");
    Button infoButton = new Button("Info");
    Button updatePasswordButton = new Button("Update Password");
    StackPane root = new StackPane();
    

    public void updateUI() {
        playerNameLabel.setText(player.getName());
        playerHealthLabel.setText(player.getHealth()+ "/ "+player.getMaxHealth());
        playerAPLabel.setText(player.getAbilityPoints()+ "/ "+player.getAbilityPoints());

        hackerNameLabel.setText(hacker.getName());
        hackerHealthLabel.setText(hacker.getHealth()+ "/ "+hacker.getMaxHealth());
        hackerAPLabel.setText(hacker.getAbilityPoints()+ "/ "+hacker.getAbilityPoints());

    }
    public void update(long timeStamp) {
        long now = System.currentTimeMillis();
        if (now - previousFrame > 35) {
            player.update();
            hacker.update();
            hacker.setScaleX(-1);
            updateUI();

            previousFrame = now;
        }
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        player.autosize();
        player.setPreserveRatio(true);
        player.setName("Player");
        hacker.autosize();
        hacker.setPreserveRatio(true);
        hacker.setName("HackBot");

        // Declare mainContainers
        VBox mainContainer = new VBox();
        VBox buttonContainer = new VBox();
        BorderPane borderPane = new BorderPane();

        VBox passwordStrengthContainer = new VBox();
        Label passwordProgressLabel = new Label("Password Strength");
        passwordProgressLabel.setStyle("-fx-text-fill: white;");
        Label passwordManagerStrengthLabel = new Label();
        ProgressBar passwordProgress = new ProgressBar();
        passwordProgress.autosize();

        passwordProgress.setProgress(((Player)player).getEquippedPassword().checkPasswordStrength() / 5 + 0.1);
        if (passwordProgress.getProgress() < 0.25) {
            passwordProgress.setStyle("-fx-accent: red;");
            passwordManagerStrengthLabel.setStyle("-fx-text-fill: rgb(229, 57, 53);");
            passwordManagerStrengthLabel.setText("WEAK");
        } else if (passwordProgress.getProgress() >= 0.25 && passwordProgress.getProgress() <.80 ) {
            passwordProgress.setStyle("-fx-accent: yellow;");
            passwordManagerStrengthLabel.setStyle("-fx-text-fill:  rgb(255, 185, 0);");
            passwordManagerStrengthLabel.setText("MEDIUM");
        } else if ((passwordProgress.getProgress() >= 0.80))  {
            passwordProgress.setStyle("-fx-accent: green;");
            passwordManagerStrengthLabel.setStyle("-fx-text-fill: rgb(25,45,200);");
            passwordManagerStrengthLabel.setText("STRONG");
        }
        passwordStrengthContainer.getChildren().addAll(passwordProgressLabel, passwordProgress, passwordManagerStrengthLabel);

        // Add buttons to appropiate containers
        HBox topButtons = new HBox(attackButton, abilityButton);
        HBox bottomButtons = new HBox(infoButton, updatePasswordButton);
        topButtons.setSpacing(5);
        bottomButtons.setSpacing(5);
        buttonContainer.getChildren().addAll(topButtons,bottomButtons);
        buttonContainer.setSpacing(5);
        buttonContainer.setStyle("-fx-border-color:black;");

        // player and enemy fields
        VBox fieldContainer = new VBox();
        HBox fieldNames = new HBox();
        fieldNames.getChildren().addAll(nameLabel,healthLabel, abilityLabel);
        nameLabel.setTextFill(Paint.valueOf("white"));
        healthLabel.setTextFill(Paint.valueOf("white"));
        abilityLabel.setTextFill(Paint.valueOf("white"));


        HBox playerField = new HBox(playerNameLabel, playerHealthLabel, playerAPLabel);
        playerNameLabel.setTextFill(Paint.valueOf("white"));
        playerHealthLabel.setTextFill(Paint.valueOf("white"));
        playerAPLabel.setTextFill(Paint.valueOf("white"));

        HBox hackerField = new HBox(hackerNameLabel,hackerHealthLabel,hackerAPLabel);
        hackerNameLabel.setTextFill(Paint.valueOf("white"));
        hackerHealthLabel.setTextFill(Paint.valueOf("white"));
        hackerAPLabel.setTextFill(Paint.valueOf("white"));

        fieldNames.setSpacing(50);
        playerField.setSpacing(50);
        hackerField.setSpacing(50);
        fieldContainer.getChildren().addAll(fieldNames,playerField,hackerField);
        fieldContainer.setPadding(new Insets(5));
        fieldContainer.setAlignment(Pos.BOTTOM_RIGHT);
        fieldContainer.setStyle("-fx-border-color:black;");

        // Dialogue Box Area
        VBox dialogueContainer = new VBox();
        HBox dialogueBox = new HBox(dialogueLabel);
        dialogueLabel.setTextFill(Paint.valueOf("white"));
        dialogueContainer.getChildren().addAll(dialogueBox);
        dialogueBox.setAlignment(Pos.CENTER);
        dialogueBox.setStyle("-fx-background-color:rgb(25,45,200,0.8);");

        HBox bottomContainer = new HBox();
        bottomContainer.getChildren().addAll(buttonContainer,passwordStrengthContainer,fieldContainer);
        bottomContainer.autosize();
        bottomContainer.setStyle("-fx-background-color:rgba(25,45,200,0.8);");
        bottomContainer.setSpacing(10);
        bottomContainer.setAlignment(Pos.CENTER);

        // Password Strength and Center Containers
        HBox spriteContainer = new HBox();
        VBox characterSpriteContainer = new VBox(player);
        VBox hackerSpriteContainer = new VBox(hacker);
        spriteContainer.getChildren().addAll(characterSpriteContainer, hackerSpriteContainer);
        spriteContainer.setStyle("-fx-background-image: url(cyberpunk_background.png);"
        + "-fx-background-size: cover;");


        /*
        Password Manager Popup Menu Objects
        */
        Popup popupPasswordMenu = new Popup();
        StackPane passwoordMenuRoot = new StackPane();
        VBox passwordManagerMainContainer = new VBox();
        // Labels
        VBox passwordManagerLabelContainer = new VBox();
        passwordManagerMainContainer.getChildren().add(passwordManagerLabelContainer);
        
        // passPhrase List Views
        HBox passPhraseContainer = new HBox();
        ObservableList <String> wordPhraseList = FXCollections.observableArrayList(
            "ILoveDolphins",
            "CloudyWithMeatballs",
            "PlayStationIsBestStation",
            "HackersGoByeBye",
            "TurtlesAreDinos",
            "KnightsAreShiny",
            "CatchMeInTheJungle"
        );
        VBox wordPhraseBox = new VBox();
        Label wordPhraseLabel = new Label("Get a passphrase below!");
        ListView <String> wordPhraseListView = new ListView<>(wordPhraseList);
        wordPhraseBox.getChildren().addAll(wordPhraseLabel, wordPhraseListView);
        
        VBox digitPhraseBox = new VBox();
        Label digitPhraseLabel = new Label("Get a number below!");
        ObservableList <Integer> digitPhraseList = FXCollections.observableArrayList(
            0,1,2,3,4,5,6,7,8,9
        );
        ListView <Integer> digitPhraseListView = new ListView<>(digitPhraseList);
        digitPhraseBox.getChildren().addAll(digitPhraseLabel,digitPhraseListView);

        VBox specialCharPhraseBox = new VBox();
        Label specialCharPhraseLabel = new Label("Get a special character!");
        ObservableList <String> specialCharPhraseList = FXCollections.observableArrayList(
        "!","@","#","$","%","^","&","*","(",")","?"    
        );
        ListView <String> specialCharPhraseListView = new ListView<>(specialCharPhraseList);
        specialCharPhraseBox.getChildren().addAll(specialCharPhraseLabel,specialCharPhraseListView);

        VBox passwordBox = new VBox();
        Label passwordLabel = new Label("These are your passwords!");
        ListView<Password> passwordListView = new ListView<>();
        // iterate through the players passwordManager and adds them to the listview
        for (int i = 0; i < ((Player)player).getPasswordManager().size(); i++) {
            passwordListView.getItems().add(((Player)player).getPasswordManager().get(i));
        }
        HBox equipBox = new HBox();
        Button equipButton = new Button("Equip");
        Label equipLabel = new Label("Currently equipped: ");
        Label currentEquipped = new Label();
        currentEquipped.setText(((Player)player).getEquippedPassword().getValue());
        equipBox.getChildren().addAll(equipButton,equipLabel,currentEquipped);
        passwordBox.getChildren().addAll(passwordLabel, passwordListView,equipBox);
        passPhraseContainer.getChildren().addAll(wordPhraseBox, digitPhraseBox, specialCharPhraseBox,passwordBox);
        passwordManagerMainContainer.getChildren().add(passPhraseContainer);
        
        // password manager buttons
        VBox passwordManagerButtonContainer = new VBox();
        Button passwordManagerAddButton = new Button("Add");
        Button passwordManagerRandomButton = new Button("Randomize");
        Button passwordManagerRemoveButton = new Button("Remove");
        passwordManagerButtonContainer.getChildren().addAll(passwordManagerAddButton,passwordManagerRandomButton,passwordManagerRemoveButton);

        HBox passwordManagerFooterContainer = new HBox();
        Button passwordManagerCloseButton = new Button("Close");
        passwordManagerFooterContainer.getChildren().addAll(passwordManagerButtonContainer,passwordManagerCloseButton);
        passwordManagerFooterContainer.setAlignment(Pos.CENTER);
        passwordManagerMainContainer.getChildren().add(passwordManagerFooterContainer);

        passwoordMenuRoot.setStyle("-fx-background-color: white;");
        passwoordMenuRoot.getChildren().add(passwordManagerMainContainer);
        popupPasswordMenu.getContent().add(passwoordMenuRoot);

        /*
         * passwordManager Button events
         */
        passwordManagerAddButton.setOnAction(event -> {
            // add the the last item the ((Player)player)s password manager arraylist to the listview if string isn't null.
            if (wordPhraseListView.getSelectionModel().getSelectedItem() !=null && digitPhraseListView.getSelectionModel().getSelectedItem() !=null && specialCharPhraseListView.getSelectionModel().getSelectedItem() != null) {
                String fullString = "";
                fullString += wordPhraseListView.getSelectionModel().getSelectedItem();
                fullString += digitPhraseListView.getSelectionModel().getSelectedItem();
                fullString += specialCharPhraseListView.getSelectionModel().getSelectedItem();
                ((Player)player).addPassword(fullString);
                passwordListView.getItems().add(((Player)player).getPasswordManager().get(((Player)player).getPasswordManager().size()-1));
            } 
        });
        passwordManagerRemoveButton.setOnAction (event -> {
            if (passwordListView.getSelectionModel().getSelectedItem() !=null) {
                int index = passwordListView.getSelectionModel().getSelectedIndex();
                ((Player)player).removePassword(index);
                passwordListView.getItems().remove(index);
                
            }
        });
        passwordManagerRandomButton.setOnAction(event -> {
            String randomString = "";
            Random random = new Random(System.nanoTime());
            int wordPhraseIndex = random.nextInt(wordPhraseListView.getItems().size()); 
            int digitPhraseIndex = random.nextInt(digitPhraseListView.getItems().size()); 
            int specialCharPhraseIndex = random.nextInt(specialCharPhraseListView.getItems().size());
            randomString += wordPhraseListView.getItems().get(wordPhraseIndex);
            randomString += digitPhraseListView.getItems().get(digitPhraseIndex);
            randomString += specialCharPhraseListView.getItems().get(specialCharPhraseIndex);
            ((Player)player).addPassword(randomString);
            passwordListView.getItems().add(((Player)player).getPasswordManager().get(((Player)player).getPasswordManager().size()-1));
        });
        passwordManagerCloseButton.setOnAction(event -> {
            popupPasswordMenu.hide();
        });

        equipButton.setOnAction(event -> {
            if ((passwordListView.getSelectionModel().getSelectedItem() != null)) {
                ((Player)player).setEquippedPassword(passwordListView.getSelectionModel().getSelectedItem());
                currentEquipped.setText(((Player)player).getEquippedPassword().getValue());
                passwordProgress.setProgress(((Player)player).getEquippedPassword().checkPasswordStrength() / 5);
        if (passwordProgress.getProgress() < 0.25) {
            passwordProgress.setStyle("-fx-accent: red;");
            passwordManagerStrengthLabel.setStyle("-fx-text-fill: rgb(229, 57, 53);");
            passwordManagerStrengthLabel.setText("WEAK");
        } else if (passwordProgress.getProgress() >= 0.25 && passwordProgress.getProgress() <.80 ) {
            passwordProgress.setStyle("-fx-accent: yellow;");
            passwordManagerStrengthLabel.setStyle("-fx-text-fill: rgb(255, 185, 0);");
            passwordManagerStrengthLabel.setText("MEDIUM");
        } else if ((passwordProgress.getProgress() >= 0.80))  {
            passwordProgress.setStyle("-fx-accent: green;");
            passwordManagerStrengthLabel.setStyle("-fx-text-fill: rgb(139, 195, 74);");
            passwordManagerStrengthLabel.setText("STRONG");
        }
            }
        });
        
        // add main container children to root
        mainContainer.getChildren().addAll(dialogueContainer, spriteContainer, bottomContainer);
        root.getChildren().addAll(mainContainer);

        /*
        * Main Button Events
        */
        
        // updatePasswordButton will open a popup window includes password manager interface
        updatePasswordButton.setOnAction(event -> {
            popupPasswordMenu.show(primaryStage);
        });

        // Attack Button
        attackButton.setOnAction(event -> {
            player.attack(hacker);
            dialogueLabel.setText(player.getName() + " attacks " + hacker.getName() + " for "+ player.getAttack());
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.0);
            fadeTransition.play();
            if (hacker.checkDefeat()) {
                hacker.defeated();
                dialogueLabel.setText(hacker.getName() +" has been defeated!");
                fadeTransition.setFromValue(1.0);
                fadeTransition.setToValue(0.0);
                fadeTransition.play();
            }
        });


        // set the main Scene;
        Scene main = new Scene(root);
        primaryStage.setScene(main);
        timer.start();
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}