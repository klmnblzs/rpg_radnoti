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
        System.out.println("========================================");
        System.out.println("$"+p.getMoney()+" | " + ReplaceMonogrammes(p.getLocation()) + " (" + p.getLocation() + ")");
        System.out.println(p.getWeapon() + " | " + p.getDmg() + " sebzés");
        System.out.println("Életerő: " + p.getHp() + "/" + p.getMaxHp() + " | " + p.getFirstAidAmt() + " elsősegély doboz");
        System.out.println("========================================");
        System.out.println();
        System.out.println("A parancsokért használd a 'help' parancsot!");
        System.out.println();
    }

    public static void DisplayMap() {
        String map = "========================================\n" +
                "    OO                                 ║\n" +
                " OOOOOOO                               ║\n" +
                " OO" + Colors.GREEN + "SF" + Colors.RESET + "OOO                               ║\n" +
                " OOOOOOO              OO               ║\n" +
                " OOOOOO              OOOOOO            ║\n" +
                "   OOO    OOOOOOOOOOOOOOOOOOOOO        ║\n" +
                "        OOOOOOOOOOOOOOOOOOOOOOOO       ║\n" +
                "        OOO" + Colors.RED + "LA" + Colors.RESET + "OOOOOOOOOOOOOOOOOOO       ║\n" +
                "         OOOOOOOOOOOOOOO" + Colors.RED + "LV" + Colors.RESET + "OOOOOO       ║\n" +
                "         OOOOOOOOOOOOOOOOOOOOO         ║SZÍNEK:\n" +
                "         OOOOOOOOOOOOOOOOO             ║  - "+Colors.CYAN+"Civilizált terület"+Colors.RESET+"\n" +
                "        OOOOOOOOOOOOOOO                ║  - "+Colors.RED+"Ellenséges terület"+Colors.RESET+"\n" +
                "       OOOOOOOOOOOOOOOOOO              ║  - "+Colors.GREEN+"Menekülési pont"+Colors.RESET+"\n" +
                "      OOOOOOOO" + Colors.CYAN + "WA" + Colors.RESET + "OOOOOOOOO              ║\n" +
                "      OOOOOOOOOOOOOOOOO" + Colors.RED + "TX" + Colors.RESET + "O             ║\n" +
                "      OOOOOOOOOOOOOOOOOOO              ║\n" +
                "     OOOOO" + Colors.RED + "NYC" + Colors.RESET + "OOOOOOOOOOOOO             ║\n" +
                "    OOOOOOOOOOOOOOOOOOOOO              ║\n" +
                "    OOOOOOOOOOOOOOOOOOOOO              ║\n" +
                "       OOOOOOOOOOO OOOO                ║\n" +
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
        locations.add("TX");

        return locations;
    }

    public static String typeWriterEffect(String text) {
        int i;
        for(i = 0; i < text.length(); i++){
            System.out.printf("%c", text.charAt(i));
            try{
                Thread.sleep(80);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }

        return text;
    }
}
