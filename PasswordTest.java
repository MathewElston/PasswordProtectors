
import passwords.*;
import java.util.*;

public class PasswordTest {
    public static void main(String[] args) {
        ArrayList<Password> passList = new ArrayList<>();
        ArrayList<Password> newList = new ArrayList<>();

        passList.add(new Password("Test123!"));
        passList.add(new Password("Test543!"));
        passList.add(new Password("no more testing!"));

        Password.save("test.ser", passList);
        newList = Password.load("test.ser");

    }

}
