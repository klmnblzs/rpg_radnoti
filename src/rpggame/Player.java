
package rpggame;

import java.util.Scanner;

public class Player {
    private int hp;
    private int maxHp;
    private String location;
    private String weapon;
    private int dmg;
    private int money;
    private boolean gotBoat;
    private int firstAidAmt;
    private int kills;

    public Player(int hp, int maxHp, String location, String weapon, int dmg, int money, boolean gotBoat, int firstAidKitAmt, int kills) {
        this.hp = 100;
        this.maxHp = 100;
        this.location = "WA";
        this.weapon = null;
        this.dmg = 10;
        this.money = 0;
        this.gotBoat = false;
        this.firstAidAmt = 0;
        this.kills = 0;
    }
    
    public void heal() {
        if(firstAidAmt!=0) {
            firstAidAmt--;
            hp=maxHp;
            System.out.println("Életerő feltöltve! Maradék elsősegély doboz: " + getFirstAidAmt());
       } else {
            System.out.println("Nem tudsz életerőt újratölteni! (Nincsen elsősegély dobozod.)");
        }
    }
    
    public void selectPlayerCast() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Válassz magadnak egy osztályt:");
        System.out.println("1.) Csontbontó");
        System.out.println("  Fegyvere egy rozsdás stop tábla.");
        System.out.println("  - Sebzése:   15 sebzés pont");
        System.out.println( " A nagyobb testfelépítésének köszönhetően sokkal több életerővel rendelkezik, viszont lomhaságából adódóan kevesebbet is sebez.");
        System.out.println("  - Életereje: 150 életerő pont");
        System.out.println("  - Fel van szerelve 2 elsősegély dobozzal.");
        System.out.println();
        System.out.println("2.) Vándor");
        System.out.println("  Fegyvere egy szögekkel kidíszített baseball ütő.");
        System.out.println("  - Sebzése:   20 sebzés pont");
        System.out.println("  Agilis, és alkalmazkodó. Tökéletesen tud közép, illetve közeli távolságból harcolni.");
        System.out.println("  - Életereje: 125 életerő pont");
        System.out.println("  - Fel van szerelve 1 elsősegély dobozzal.");
        System.out.println();
        System.out.println("3.) Íjász");
        System.out.println("  Fegyvere egy csigás íj, magyar nyílvesszőkkel.");
        System.out.println("  - Sebzése:   25 sebzés pont");
        System.out.println("  Kevés életerővel rendelkezik, de a távolból hatalmas sebzést tud felmérni ellenfelére.");
        System.out.println("  - Életereje: 100 életerő pont");
        System.out.println("  - Nincsen kezdőleges elsősegély doboza.");
        System.out.println();
        
        System.out.print("> ");
        String choice = sc.nextLine();

        while(!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
            System.out.println("Kérlek a következő opciókkal válaszolj: 1, 2, vagy 3");
            System.out.print("> ");
            choice = sc.nextLine();
        }

        switch(choice){
            case "1":
                this.hp = 150;
                this.maxHp=150;
                this.firstAidAmt = 2;
                this.weapon = "Stop tábla";
                this.dmg = 15;
                break;

            case "2":
                this.hp = 125;
                this.maxHp= 125;
                this.firstAidAmt = 1;
                this.weapon = "Szöges baseball ütő";
                this.dmg = 20;
                break;

            case "3":
                this.hp = 100;
                this.maxHp=100;
                this.firstAidAmt = 0;
                this.weapon = "Csigás íj";
                this.dmg = 25;
                break;

            default:
                break;
        }
    }
    
    public boolean  checkHeal() {
        return hp <= maxHp - 100;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public boolean isAlive() {
        return hp>0;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isGotBoat() {
        return gotBoat;
    }

    public void setGotBoat(boolean gotBoat) {
        this.gotBoat = gotBoat;
    }

    public int getFirstAidAmt() {
        return firstAidAmt;
    }

    public void setFirstAidAmt(int firstAidAmt) {
        this.firstAidAmt = firstAidAmt;
    }
    

    @Override
    public String toString() {
        return "Player{" + "hp=" + hp + ", maxHp=" + maxHp + ", location=" + location + ", weapon=" + weapon + ", dmg=" + dmg + '}';
    }
    
}
