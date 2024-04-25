package rpggame;

import java.util.ArrayList;
import java.util.Scanner;
import static rpggame.Utils.ClearConsole;

public class RpgGame {
    public static void main(String[] args) {
        Player p = new Player(0, 0, "WA", "Feszítővas", 0, 0, true, 0, 0);
        
        Scanner sc = new Scanner(System.in);
        boolean game = true;
        ClearConsole(p);
        
        while(game) {
            
            System.out.print("> ");
            String loc = sc.nextLine();
            
            UserInput(loc, p);
       }
    }
    
    public static void DisplayPlayerStats(Player p) {
        System.out.println("Péz: $" + p.getMoney());
        System.out.println("Fegyver: " + p.getWeapon());
        System.out.println("HP: " + p.getHp() + "/" + p.getMaxHp());
        System.out.println("Dmg: " + p.getDmg());
        System.out.println("Location: " + ReplaceMonogrammes(p.getLocation()));
        System.out.println("First Aid: " + p.getFirstAidKitAmt());
        System.out.println("");
    }
    
    public static void DisplayMap() {
        String map =    "============================================\n" +
                        "                                           ║\n" +
                        "                                           ║\n" +
                        "    OO                                     ║\n" +
                        " OOOOOOO                                   ║\n" +
                        " OO"+ColorManager.GREEN+"SF"+ColorManager.RESET+"OOO                                   ║ PARANCSOK: \n" +
                        " OOOOOOO              OO                   ║ - go\n" +
                        " OOOOOO              OOOOOO                ║ - heal\n" +
                        "   OOO    OOOOOOOOOOOOOOOOOOOOO            ║ - shop\n" +
                        "        OOOOOOOOOOOOOOOOOOOOOOOO           ║ - help\n" +
                        "        OOO"+ColorManager.BLUE+"LA"+ColorManager.RESET+"OOOOOOOOOOOOOOOOOOO           ║\n" +
                        "         OOOOOOOOO"+ColorManager.BLUE+"LV"+ColorManager.RESET+"OOOOOOOOOOOO           ║\n" +
                        "         OOOOOOOOOOOOOOOOOOOOO             ║\n" +
                        "         OOOOOOOOOOOOOOOOO                 ║\n" +
                        "        OOOOOOOOOOOOOOO                    ║\n" +
                        "       OOOOOOOOOOOOOOOOOO                  ║\n" +
                        "      OOOOOOOO"+ColorManager.BLUE+"WA"+ColorManager.RESET+"OOOOOOOOO                  ║\n" +
                        "      OOOOOOOOOOOOOOOOO"+ColorManager.BLUE+"JA"+ColorManager.RESET+"O                 ║\n" +
                        "      OOOOOOOOOOOOOOOOOOO         OOO      ║\n" +
                        "     OOOOO"+ColorManager.BLUE+"NYC"+ColorManager.RESET+"OOOOOOOOOOOOO       OOOOOO    ║\n" +
                        "    OOOOOOOOOOOOOOOOOOOOO    OOOOOOO"+ColorManager.BLUE+"H"+ColorManager.RESET+"OO    ║\n" +
                        "    OOOOOOOOOOOOOOOOOOOOO   OOOOOOOOOOO    ║\n" +
                        "        OOOOOOOOOOOOOOOO    OOOOOOOOOOOO   ║\n" +
                        "        OOOO"+ColorManager.BLUE+"TX"+ColorManager.RESET+"OOOOOOO"+ColorManager.BLUE+"SJ"+ColorManager.RESET+"OOO   OOOOOOOOOOOO  ║\n" +
                        "        OOOOOOOOOOOOOOOOO   OOOOOOOOOOOO   ║\n" +
                        "         OOOOOOOOOOOOOOO    OOOOOOOOOOOO   ║\n" +
                        "         OOOOOOOOO OOOO     OOOO"+ColorManager.BLUE+"CH"+ColorManager.RESET+"OOOOOO   ║\n" +
                        "          OOOOOO            OOOOOOOOOOO    ║\n" +
                        "                             OOOOOOOOO     ║\n" +
                        "                             OOOOOOOO      ║\n" +
                        "                              OOO          ║\n" +
                        "                                           ║\n" +
                        "============================================\n";
        
        System.out.println(map);
    }
    
    public static ArrayList<String> getLocations() {
        ArrayList<String> locations = new ArrayList<String>();
        locations.add("SF");
        locations.add("LV");
        locations.add("LA");
        locations.add("NYC");
        locations.add("WA");
        locations.add("CH");
        locations.add("JA");
        locations.add("SJ");
        locations.add("H");
        locations.add("TX");
        
        return locations;
    }
    
    public static String ReplaceMonogrammes(String loc) {
        switch(loc) {
                case "SF":
                    return("San Francisco");
                case "LV":
                    return("Las Vegas");
                case "LA":
                    return("Los Angeles");
                case "NYC":
                    return("New York City");
                case "WA":
                    return("Washington");
                case "CH":
                    return("Chicago");
                case "JA":
                    return("Jacksonville");
                case "SJ":
                    return("San Jose");
                case "H":
                    return("Houston");
                case "TX":
                    return("Texas");
                default:
                    return("Gatya");           
        }
    }
    
    public static void wait(int numSeconds){
        try {
            Thread.sleep(numSeconds * 1000);
        } catch (InterruptedException e) {
            
        }
    }
    
    public static void UserInput(String userInput, Player p) {
        switch(userInput.split(" ")[0]) {
            case "go":
                if(userInput.split(" ").length==1) {
                    System.out.println("Utazható helyek: ");
                    for(String s : getLocations()) {
                        System.out.print(s + ", ");
                    }
                    System.out.println("");
                } else {
                    for(String s : getLocations()) {
                        if(p.getLocation().equals(userInput.split(" ")[1])) {
                            System.out.println("Már itt vagy");
                            wait(2);
                            break;
                        }
                        else if(userInput.split(" ")[1].equals(s)) {
                            p.setLocation(s);
                            System.out.println("ide mentél: " + s);
                            wait(2);
                            break;
                        }
                    }
                    ClearConsole(p);
                    break;
                }
            case "heal":
                p.heal();
                wait(2);
                ClearConsole(p);
                break;
            case "shop":
                if(p.getLocation().equals("WA")) {
                    if(userInput.split(" ").length==1) {
                        System.out.println("Fegyvered (" + p.getWeapon() + ") fejlesztése");
                        System.out.println("  - Új damage: " + Integer.toString(p.getDmg() + 1));
                        System.out.println("  - $100");
                        System.out.println(" Fejlesztesz? (Y/N)");
                        System.out.print("> ");
                        Scanner sc = new Scanner(System.in);
                        String choice = sc.nextLine();
                        
                        if(choice.equals("n") || choice.equals("N")) {
                            ClearConsole(p);
                        } else {
                            System.out.println("fejlesztés majd ide....");
                            wait(2);
                            ClearConsole(p);
                        }
                        
                        wait(2);
                        break;
                    }
                } else {
                    System.out.println("Csak Washingtonba tudsz vásárolni/fejleszteni!");
                    wait(2);
                    ClearConsole(p);
                }
                break;
            case "help":
                ClearConsole(p);
                System.out.println("PARANCSOK:");
                System.out.println(" - go <hely>");
                System.out.println(" - heal");
                System.out.println(" - shop");
                System.out.println(" - help");
                break;
            default:
                ClearConsole(p);
                System.out.println("PARANCSOK:");
                System.out.println(" - go <hely>");
                System.out.println(" - heal");
                System.out.println(" - shop");
                System.out.println(" - help");
                break;
        }
    }
}
