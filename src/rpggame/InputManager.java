package rpggame;

import java.util.ArrayList;
import java.util.Scanner;
import static rpggame.Utils.ClearConsole;
import static rpggame.Utils.getLocations;

public class InputManager {
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
                        if(userInput.split(" ")[1].toUpperCase().equals("SF")) {
                            if(p.isGotBoat()) {
                                p.setLocation("SF");
                                break;
                            } else {
                                System.out.println("Meg kell venned a hajót, hogy el tudj menekülni!");
                                wait(2);
                                break;
                            }
                        }
                        else if(p.getLocation().equals(userInput.split(" ")[1])) {
                            System.out.println("Már itt vagy");
                            wait(2);
                            break;
                        }
                        else if(userInput.split(" ")[1].toUpperCase().equals(s)) {
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
