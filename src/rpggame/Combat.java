package rpggame;

import java.util.Random;

public class Combat {
    public static void wait(int numSeconds) {
        try {
            Thread.sleep(numSeconds * 1000);
        } catch (InterruptedException e) {

        }
    }

    public static boolean checkDodge() {
        Random r = new Random();
        int chances = r.nextInt(10-1+1) + 1;

        if(chances > 9) {
            return true;
        }

        return false;
    }

    public static boolean checkCritHit() {
        Random r = new Random();
        int chances = r.nextInt(10-1+1) + 1;

        if(chances > 9) {
            return true;
        }

        return false;
    }

    public static boolean genRandomFight() {
        Random r = new Random();
        int chances = r.nextInt(10-1+1) + 1;

        if(chances > 8) {
            return true;
        }

        return false;
    }

    public static void fightPrototype(Player p, Enemy e) {
        boolean playerTurn = true;
        Random r = new Random();

        System.out.println();

        while(p.isAlive() && e.isAlive()) {
            if(playerTurn) {
                if(p.checkHeal()) {
                    p.heal();
                }

                int damageDealt = 0;

                if(!checkDodge()) {
                    if(!checkCritHit()) {
                        damageDealt = r.nextInt(p.getDmg()-5+1) + 5;
                    } else {
                        damageDealt =  (r.nextInt(p.getDmg()-5+1) + 5) + r.nextInt((p.getDmg()+10)-p.getDmg()+1) + p.getDmg();
                        System.out.println("KRITIKUS SEBZÉS!");
                    }
                    e.setHp(e.getHp()-damageDealt);

                    System.out.println("Te: Megsebezted a(z) " + e.getName() + "-at/et, " + damageDealt + " életpontra. Maradék élete: " + (e.getHp() < 0 ? 0 : e.getHp()));
                    System.out.println();
                    playerTurn = false;
                    wait(3);
                } else {
                    System.out.println(e.getName() + " kitért az ütés elől!");
                    System.out.println();
                    playerTurn = false;
                    wait(3);
                }
            } else {
                if(e.checkHeal()) {
                    e.heal();
                }

                int damageDealt = 0;

                if(!checkDodge()) {
                    if(!checkCritHit()) {
                        damageDealt = r.nextInt(p.getDmg()-5+1) + 5;
                    } else {
                        damageDealt =  (r.nextInt(p.getDmg()-5+1) + 5) + r.nextInt((p.getDmg()+10)-p.getDmg()+1) + p.getDmg();
                        System.out.println("KRITIKUS SEBZÉS!");
                        p.setHp(p.getHp()-damageDealt);

                        System.out.println(e.getName() + ": Megsebzett téged " + damageDealt + " életpontra. Maradék életed: " + p.getHp());
                        System.out.println();
                        playerTurn = true;
                        wait(3);
                    }
                } else {
                    System.out.println("Kitértél az ütés elől!");
                    System.out.println();
                    playerTurn = true;
                    wait(3);
                }
            }
        }

        if(!e.isAlive()) {
            System.out.println(e.getName() + " legyőzve! Jutalmad: 15 peso");
        } else if(!p.isAlive()) {
            System.out.println("Meghaltál!");
        }
    }
}
