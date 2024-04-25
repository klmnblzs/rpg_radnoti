/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpggame;

import java.util.ArrayList;
import static rpggame.RpgGame.DisplayMap;
import static rpggame.RpgGame.DisplayPlayerStats;

/**
 *
 * @author 72589082135
 */
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
}
