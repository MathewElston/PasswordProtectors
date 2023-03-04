package test;

import characters.Player;
import passwords.Password;
import characters.Hacker;
import abilities.Phishing;
import abilities.Ability;
import abilities.BruteForce;
import characters.Character;

public class StatTest {
    public static void main(String[] args) {
        Player player2 = new Player();
        Hacker hacker = new Hacker();
        Password myPass = new Password("Hello World");
        Character player = new Player();

        Password equip = new Password("12345678910abcDEFG!");
        Password equip2 = new Password("S");
        Password nulPassword = new Password();
        Ability phish = new Phishing();
        Ability bruteForce = new BruteForce(5);


        ((Player)player).setEquippedPassword(equip);
        phish.use(player);
        player.setHealth(50);
        player.setMaxHealth(50);
        System.out.println(player.getHealth());
        bruteForce.use(player);
        System.out.println(player.getHealth());

        


    }
}
