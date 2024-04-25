package rpggame;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Utils {
    public static void CheckContain(String userInput, ArrayList<String> list) {
        for (String s : list) {
            if (userInput.equals(s)) {
                System.out.println(userInput + " benne van");
            }
        }
    }

    public static void ClearConsole(Player p) {
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }

        DisplayMap();
        DisplayPlayerStats(p);
    }

    public static void ClearFullConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }

    public static void DisplayPlayerStats(Player p) {
        System.out.println("$ "+p.getMoney()+" | " + ReplaceMonogrammes(p.getLocation()) + " (" + p.getLocation() + ")");
        System.out.println(p.getWeapon() + " | " + p.getDmg() + " sebzés");
        System.out.println("Életerő: " + p.getHp() + "/" + p.getMaxHp() + " | " + p.getFirstAidAmt() + " elsősegély doboz");
        System.out.println();
    }

    public static void DisplayMap() {
        String map = "========================================\n" +
                "    OO                                 ║\n" +
                " OOOOOOO                               ║\n" +
                " OO" + Colors.GREEN + "SF" + Colors.RESET + "OOO                               ║ PARANCSOK: \n" +
                " OOOOOOO              OO               ║ - go\n" +
                " OOOOOO              OOOOOO            ║ - heal\n" +
                "   OOO    OOOOOOOOOOOOOOOOOOOOO        ║ - shop\n" +
                "        OOOOOOOOOOOOOOOOOOOOOOOO       ║ - help\n" +
                "        OOO" + Colors.BLUE + "LA" + Colors.RESET + "OOOOOOOOOOOOOOOOOOO       ║\n" +
                "         OOOOOOOOO" + Colors.BLUE + "LV" + Colors.RESET + "OOOOOOOOOOOO       ║\n" +
                "         OOOOOOOOOOOOOOOOOOOOO         ║\n" +
                "         OOOOOOOOOOOOOOOOO             ║\n" +
                "        OOOOOOOOOOOOOOO                ║\n" +
                "       OOOOOOOOOOOOOOOOOO              ║\n" +
                "      OOOOOOOO" + Colors.BLUE + "WA" + Colors.RESET + "OOOOOOOOO              ║\n" +
                "      OOOOOOOOOOOOOOOOO" + Colors.BLUE + "JA" + Colors.RESET + "O             ║\n" +
                "      OOOOOOOOOOOOOOOOOOO              ║\n" +
                "     OOOOO" + Colors.BLUE + "NYC" + Colors.RESET + "OOOOOOOOOOOOO             ║\n" +
                "    OOOOOOOOOOOOOOOOOOOOO              ║\n" +
                "    OOOOOOOOOOOOOOOOOOOOO              ║\n" +
                "        OOOOOOOOOOOOOOOO               ║\n" +
                "        OOOO" + Colors.BLUE + "TX" + Colors.RESET + "OOOOOOO" + Colors.BLUE + "SJ" + Colors.RESET + "OOO             ║\n" +
                "        OOOOOOOOOOOOOOOOO              ║\n" +
                "         OOOOOOOOOOOOOOO               ║\n" +
                "         OOOOOOOOO OOOO                ║\n" +
                "          OOOOOO                       ║\n" +
                "========================================\n";

        System.out.println(map);
    }

    public static String ReplaceMonogrammes(String loc) {
        switch (loc) {
            case "SF":
                return ("San Francisco");
            case "LV":
                return ("Las Vegas");
            case "LA":
                return ("Los Angeles");
            case "NYC":
                return ("New York City");
            case "WA":
                return ("Washington");
            case "JA":
                return ("Jacksonville");
            case "SJ":
                return ("San Jose");
            case "TX":
                return ("Texas");
            default:
                return ("Hibás");
        }
    }

    public static ArrayList<String> getLocations() {
        ArrayList<String> locations = new ArrayList<String>();
        locations.add("SF");
        locations.add("LV");
        locations.add("LA");
        locations.add("NYC");
        locations.add("WA");
        locations.add("JA");
        locations.add("SJ");
        locations.add("TX");

        return locations;
    }
}
