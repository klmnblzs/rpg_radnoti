package rpggame;

import java.util.Scanner;

import static rpggame.Commands.CommandInterpreter;
import static rpggame.Utils.ClearConsole;
import static rpggame.Utils.ClearFullConsole;

public class RpgGame {
    public static void main(String[] args) {
        Player p = new Player(0, 0, "WA", null, 0, 0, false, 0, 0);
        Scanner sc = new Scanner(System.in);
        boolean game = true;

        System.out.println("Felébredsz az autódban és csak egy nagy csattanásra emlékszel.\nMagad mellett találsz egy levelet melyből megtudod, hogy a családod San Franciscoban tartózkodik.\nKinézel az ablakon és megpillantod a világvégét. Szemed elé tárul egy olyan világ amelyben a civilizáció teljesen felborult.\nCsak saját magadra számíthatsz ebben a posztapokaliptikus világban. \n" +
                "\n" +
                "Miután kimászol az autódból fegyverek tűnnek fel a szemed előtt, és 3 választást látsz magad előtt. Dönts okosan!");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        System.out.println("\n\nNyomj entert a folytatáshoz...");
        sc.nextLine();
        ClearFullConsole();

        p.selectPlayerCast();
        ClearConsole(p);
        System.out.println("Utazni  a 'go' paranccsal tudsz.");
        System.out.println("Ha ellenséges területre mentél, akkor a 'fight' paranccsal tudsz indítványozni támadást!");
        while(game) {
            if(!p.isAlive()) {
                game=false;
            }
            else  if(p.getLocation().equals("SF")) {
                game=false;
                ClearFullConsole();
                Utils.typeWriterEffect("Elutaztál a menekülési pontra, és a családodat biztonságban találtad.");
            } else {
                System.out.print("> ");
                String loc = sc.nextLine();

                CommandInterpreter(loc, p);
            }
       }
    }
}
