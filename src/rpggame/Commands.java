package rpggame;

import java.sql.SQLOutput;

import static rpggame.Utils.*;

public class Commands {
    public static void wait(int numSeconds){
        try {
            Thread.sleep(numSeconds * 1000);
        } catch (InterruptedException e) {
            
        }
    }

    public static void displayHelp() {
        System.out.println("PARANCSOK:");
        System.out.println(" - go (hova) - Utazás másik városokba");
        System.out.println("  - Példa: go tx");
        System.out.println(" - heal - Életerő feltöltése. Kell hozzá elsősegély doboz!");
        System.out.println(" - upgrade (mit) - Arzenálod fejlesztése.");
        System.out.println("  - Fejleszthető tárgyak listázásához, csak írd be, hogy 'upgrade'!");
        System.out.println("  - Példa: upgrade 1");
        System.out.println(" - buy (mit)");
        System.out.println("  - Vásárolható tárgyak listázásához, csak írd be, hogy 'buy'!");
        System.out.println("  - Példa: buy 1");
        System.out.println(" - fight");
        System.out.println("  - Washingtonon kívül bárhol tudsz harcolni!");
    }

    public static void CommandInterpreter(String userInput, Player p) {
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
                                Enemy e = Enemy.generateStats(p);
                                System.out.println();
                                System.out.println("Az utadon "+ Utils.ReplaceMonogrammes(p.getLocation()) + "-ba/be, rád támadt egy " + e.getName() + "!");
                                wait(2);
                                Combat.randomFight(p, e);
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
            case "upgrade":
                if(p.getLocation().equals("WA")) {
                    if(userInput.split(" ").length==1) {
                        System.out.println("Elérhető fejlesztések:");
                        System.out.println(" 1. - Fegyver");
                        System.out.println("  1.1 - Nagyobb sebzés (+5)");
                        System.out.println("  1.2 - Ára: $" + Shop.getWeaponUpgrade());
                        System.out.println(" 2. - Páncél");
                        System.out.println("  2.1 - Több életerő (+5)");
                        System.out.println("  2.2 - Ára: $" + Shop.getArmorUpgrade());
                        System.out.println();
                        System.out.println("Példa fejlesztés: upgrade 1");
                        System.out.println(" - Ezzel a fegyveredet fejleszted.");
                        wait(2);
                        break;
                    }

                    else if(userInput.split(" ").length==2) {
                        String playerItem = userInput.split(" ")[1];
                        int playerMoney = p.getMoney();
                        switch(playerItem) {
                            case "1":
                                if(playerMoney >= Shop.getWeaponUpgrade()) {
                                    Shop.setWeaponUpgrade(Shop.getWeaponUpgrade() + 100);
                                    p.setMoney(playerMoney - Shop.getWeaponUpgrade());
                                    p.setDmg(p.getDmg() + 5);
                                    ClearFullConsole();

                                    System.out.println("Sikeres vásárlás! $" + Shop.getWeaponUpgrade() + " levonva. A sebzésed +5 ponttal feljebb ment! Új sebzésed: " + p.getHp());
                                    wait(2);
                                    ClearConsole(p);
                                } else {
                                    ClearFullConsole();
                                    System.out.println("Nincsen elegendő pénzed a fegyvered fejlesztéséhez!");
                                    wait(2);
                                    ClearConsole(p);
                                }
                                break;
                            case "2":
                                if(playerMoney >= Shop.getArmorUpgrade()) {
                                    Shop.setArmorUpgrade(Shop.getArmorUpgrade() + 150);
                                    p.setMoney(playerMoney - Shop.getArmorUpgrade());
                                    p.setHp(p.getHp() + 5);
                                    p.setMaxHp(p.getMaxHp() + 5);
                                    ClearFullConsole();

                                    System.out.println("Sikeres vásárlás! $" + Shop.getArmorUpgrade() + " levonva. Az életerőd +5 ponttal feljebb ment! Új életerőd: " + p.getHp());

                                    wait(2);
                                    ClearConsole(p);
                                } else {
                                    ClearFullConsole();
                                    System.out.println("Nincsen elegendő pénzed a páncélod fejlesztéséhez!");
                                    wait(2);
                                    ClearConsole(p);
                                }
                                break;
                            default:
                                ClearFullConsole();
                                System.out.println("Ilyen tárgy nincsen.");
                                wait(2);
                                ClearConsole(p);
                                break;
                        }
                        break;
                    }
                } else {
                    ClearFullConsole();
                    System.out.println("A legközelebbi bolt Washingtonban (WA) van. Utazz oda, ha szeretnél vásárolni!");
                    wait(2);
                    ClearConsole(p);
                }
                break;
            case "buy":
                if(p.getLocation().equals("WA")) {
                    if (userInput.split(" ").length == 1) {
                        System.out.println("Elérhető tárgyak:");
                        System.out.println(" 1. - Elsősegély doboz");
                        System.out.println("  1.1 - Feltölti az életerőd");
                        System.out.println("  1.2 - Ára: $" + Shop.getFirstAidPrice());
                        System.out.println(" 2. - Csónak");
                        System.out.println("  2.1 - Ezzel a tárggyal tudod lezárni a játékot! Menekülési útvonalat biztosít a szigetről.");
                        System.out.println("  2.2 - Ára: $" + Shop.getBoatPrice());
                        System.out.println();
                        System.out.println("Példa vásárlás: buy 1");
                        System.out.println(" - Ezzel a fegyveredet fejleszted.");
                        wait(2);
                        break;
                    }

                    else if(userInput.split(" ").length==2) {
                        String playerItem = userInput.split(" ")[1];
                        int playerMoney = p.getMoney();
                        switch(playerItem) {
                            case "1":
                                if(playerMoney >= Shop.getFirstAidPrice()) {
                                    p.setFirstAidAmt(p.getFirstAidAmt() + 1);
                                    ClearFullConsole();

                                    System.out.println("Egy elsősegély doboz hozzáadva az eszköztáradhoz! Elsősegély dobozaid száma: " + p.getFirstAidAmt());

                                    wait(2);
                                    ClearConsole(p);
                                } else {
                                    ClearFullConsole();
                                    System.out.println("Nincsen elegendő pénzed az elsősegély doboz megvásárlásához!");
                                    wait(2);
                                    ClearConsole(p);
                                }

                                break;
                            case "2":
                                if(playerMoney >= Shop.getBoatPrice()) {
                                    p.setGotBoat(true);
                                    ClearFullConsole();

                                    System.out.println("Megvásároltad a hajót!");
                                    System.out.println("Mostmár el tudsz menekülni San Franciscoba.");

                                    wait(2);
                                    ClearConsole(p);
                                } else {
                                    ClearFullConsole();
                                    System.out.println("Nincsen elegendő pénzed a hajó megvásárlásához!");
                                    wait(2);
                                    ClearConsole(p);
                                }
                                break;
                            default:
                                ClearFullConsole();
                                System.out.println("Ilyen tárgy nincsen.");
                                wait(2);
                                ClearConsole(p);
                                break;
                        }
                    }
                } else {
                    ClearFullConsole();
                    System.out.println("A legközelebbi bolt Washingtonban (WA) van. Utazz oda, ha szeretnél vásárolni!");
                    wait(2);
                    ClearConsole(p);
                }
            case "fight":
                if(!p.getLocation().equals("WA")) {
                    ClearFullConsole();
                    Enemy e = Enemy.generateStats(p);
                    Combat.randomFight(p, e);
                    wait(2);
                    ClearConsole(p);
                } else {
                    System.out.println("Washingtonban nem tudsz harcolni! Ez egy civilizált terület.");
                    wait(2);
                    ClearConsole(p);
                }
            case "help":
                ClearConsole(p);
                displayHelp();
                break;
            default:
                ClearConsole(p);
                displayHelp();
                break;
        }
    }
}
