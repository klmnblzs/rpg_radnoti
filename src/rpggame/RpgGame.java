package rpggame;

import java.util.ArrayList;
import java.util.Scanner;
import static rpggame.InputManager.UserInput;
import static rpggame.Utils.ClearConsole;

public class RpgGame {
    public static void main(String[] args) {
        Player p = new Player(0, 0, "WA", null, 0, 0, false, 0, 0, 0);
        p.selectPlayerCast();
        
        Scanner sc = new Scanner(System.in);
        boolean game = true;
        ClearConsole(p);
        
        
        while(game) {
            
            System.out.print("> ");
            String loc = sc.nextLine();
            
            UserInput(loc, p);
       }
    }
}
