package rpggame;

import java.util.Scanner;

import static rpggame.Utils.*;

public class Commands {
    public static void wait(int numSeconds){
        try {
            Thread.sleep(numSeconds * 1000);
        } catch (InterruptedException e) {
            
        }
    }
    
    public static void UserInput(String userInput, Player p) {
        switch(userInput.split(" ")[0].toLowerCase()) {
            case "go":
                if(userInput.split(" ").length==1) {
                    System.out.println("Utazható helyek: ");
                    for(String s : getLocations()) {
                        System.out.print(s + ", ");
                    }
                    System.out.println("");
                    wait(2);
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
                        else if(p.getLocation().equals(userInput.split(" ")[1].toUpperCase())) {
                            System.out.println("Már itt vagy");
                            wait(2);
                            break;
                        }
                        else if(userInput.split(" ")[1].toUpperCase().equals(s)) {
                            Utils.ClearFullConsole();
                            p.setLocation(s);
                            System.out.println("Elutaztál " + Utils.ReplaceMonogrammes(s) + "-ba/be!");
                            if(Combat.genRandomFight()) {
                                ClearFullConsole();
                                Enemy e = Enemy.generateStats();
                                System.out.println();
                                System.out.println("Az utadon "+ Utils.ReplaceMonogrammes(p.getLocation()) + "-ba/be, rád támadt egy " + e.getName() + "!");
                                wait(2);
                                Combat.fightPrototype(p, e);
                            }
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
                        System.out.println("--- FEGYVER ---");
                        System.out.println("1. " + p.getWeapon() + " fejlesztése");
                        System.out.println(" - +3 dmg");
                        System.out.println(" $20");

                        wait(2);
                        break;
                    }
                } else {
                    System.out.println("A legközelebbi bolt Washingtonban (WA) van. Utazz oda, ha szeretnél vásárolni!");
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
