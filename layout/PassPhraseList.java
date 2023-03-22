package layout;

import characters.Player;
import characters.Character;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import passwords.Password;

public class PassPhraseList extends HBox {
        private VBox wordPhraseBox = new VBox();
        private Label wordPhraseLabel = new Label("Get a passphrase below!");
        private ObservableList<String> wordPhraseList = FXCollections.observableArrayList(
                        "CandyRainbow",
                        "MagicalUnicorn",
                        "FriendlyDragon",
                        "LuckyLadybug",
                        "RainyDayFun",
                        "SuperheroAdventure",
                        "DinoRoar",
                        "SpaceExplorer",
                        "MysteryIsland",
                        "PirateTreasure",
                        "WildWestAdventure",
                        "RobotFriend",
                        "GardenButterfly",
                        "SafariAdventure",
                        "FairyTaleLand",
                        "UnderwaterWorld",
                        "ToyBoxSurprise",
                        "JungleExplorer",
                        "SportsChampion",
                        "PizzaParty",
                        "ILoveDolphins",
                        "CloudyWithMeatballs",
                        "PlayStationIsBestStation",
                        "HackersGoByeBye",
                        "TurtlesAreDinos",
                        "KnightsAreShiny",
                        "CatchMeInTheJungle",
                        "StarGazerDreams",
                        "RainbowButterfly",
                        "SunflowerSunshine",
                        "PirateTreasureIsland",
                        "MagicalUnicornLand",
                        "DragonFireBreath",
                        "UnderwaterAdventure",
                        "ForestFairyTale",
                        "CircusElephantShow",
                        "SpaceRocketExplorer",
                        "GardenLadybugFun",
                        "DinoRoarAttack",
                        "WizardMagicWand",
                        "RobotFriendForever",
                        "OceanMermaidCastle",
                        "RaceCarChampion",
                        "JungleSafariAdventure",
                        "KnightDragonBattle",
                        "HauntedHouseMystery",
                        "SportsSuperstarWin");
        private ListView<String> wordPhraseListView = new ListView<>(wordPhraseList);

        private VBox specialCharPhraseBox = new VBox();
        private Label specialCharPhraseLabel = new Label("Get a special character!");
        private ObservableList<String> specialCharPhraseList = FXCollections.observableArrayList(
                        "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "?");
        private ListView<String> specialCharPhraseListView = new ListView<>(specialCharPhraseList);

        private VBox digitPhraseBox = new VBox();
        private Label digitPhraseLabel = new Label("Get a number below!");
        private ObservableList<Integer> digitPhraseList = FXCollections.observableArrayList(
                        0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        private ListView<Integer> digitPhraseListView = new ListView<>(digitPhraseList);

        private VBox passwordBox = new VBox();
        private Label passwordLabel = new Label("These are your passwords!");
        private ListView<Password> passwordListView = new ListView<>();

        public PassPhraseList(Character player) {
                super();
                wordPhraseBox.getChildren().addAll(wordPhraseLabel, wordPhraseListView);
                specialCharPhraseBox.getChildren().addAll(specialCharPhraseLabel, specialCharPhraseListView);
                digitPhraseBox.getChildren().addAll(digitPhraseLabel, digitPhraseListView);
                this.passwordBox.getChildren().addAll(passwordLabel, passwordListView);
                this.getChildren().addAll(wordPhraseBox, specialCharPhraseBox, digitPhraseBox, passwordBox);
                if (player instanceof Player) {
                        for (int i = 0; i < ((Player) player).getPasswordManager().size(); i++) {
                                this.passwordListView.getItems().add(((Player) player).getPasswordManager().get(i));
                        }
                }

        }

}
