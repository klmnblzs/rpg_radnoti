package rpggame;

import java.util.Scanner;

import static rpggame.Commands.UserInput;
import static rpggame.Utils.ClearConsole;

public class RpgGame {
    public static void main(String[] args) {
        Player p = new Player(0, 0, "WA", null, 0, 0, false, 0);
        p.selectPlayerCast();


        Scanner sc = new Scanner(System.in);
        boolean game = true;
        ClearConsole(p);
        
        while(game) {
            if(p.getLocation().equals("SF")) {
                System.out.println("badum tss");
                game=false;
            }
            if(!p.isAlive()) {
                game=false;
            }

            System.out.print("> ");
            String loc = sc.nextLine();
            
            UserInput(loc, p);
       }
    }
}
