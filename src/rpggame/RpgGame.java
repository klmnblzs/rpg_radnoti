package rpggame;

import java.util.Scanner;

import static rpggame.Commands.CommandInterpreter;
import static rpggame.Utils.ClearConsole;

public class RpgGame {
    public static void main(String[] args) {
        Player p = new Player(0, 0, "WA", null, 0, 0, false, 0, 0);
        Scanner sc = new Scanner(System.in);
        boolean game = true;
        p.selectPlayerCast();
        ClearConsole(p);
        while(game) {
            if(!p.isAlive()) {
                game=false;
            }
            if(p.getLocation().equals("SF")) {
                game=false;
                System.out.println("jatek vege ide");
            } else {
                System.out.print("> ");
                String loc = sc.nextLine();

                CommandInterpreter(loc, p);
            }
       }
    }
}
