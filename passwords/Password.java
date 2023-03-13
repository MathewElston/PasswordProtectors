package passwords;

import java.io.*;
import java.util.*;

public class Password implements PasswordStrengthChecker, Serializable {
    private String value;

    public Password() {
    }

    public Password(String value) {
        this.value = value;
    }

    public int checkPasswordStrength() {
        // total possible strength is 5
        int strength = 0;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        for (int i = 0; i < this.value.length(); i++) {
            char c = this.value.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }
        if (this.value.length() >= 8 && this.value.length() < 16) {
            strength++;
        } else if (this.value.length() >= 16) {
            strength += 2;
        }
        if (hasUpper) {
            strength++;
        }
        if (hasDigit) {
            strength++;
        }
        if (hasSpecialChar) {
            strength++;
        }
        return strength;
    }

    public boolean verify(String passwordAttempt) {
        boolean isVerified;
        if (passwordAttempt == this.value) {
            isVerified = true;
        } else {
            isVerified = false;
        }
        return isVerified;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static void save(String file, ArrayList<Password> passwords) {
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(passwords);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static ArrayList<Password> load(String file) {
        try {
            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(file));
            ArrayList<Password> passwords = (ArrayList<Password>) objectIn.readObject();
            objectIn.close();
            for (Password password : passwords) {
                System.out.println("Loaded: " + password + "\n");
            }
            return passwords;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

}
