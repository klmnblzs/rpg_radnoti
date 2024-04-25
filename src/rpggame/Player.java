
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
    private int starvation;
    private int energy;

    public Player(int hp, int maxHp, String location, String weapon, int dmg, int money, boolean gotBoat, int firstAidKitAmt, int energy, int starvation) {
        this.hp = 100;
        this.maxHp = 100;
        this.location = "WA";
        this.weapon = null;
        this.dmg = 10;
        this.money = 0;
        this.gotBoat = false;
        this.firstAidAmt = 0;
        this.starvation = 100;
        this.energy = 100;
    }
    
    public void heal() {
        if(firstAidAmt!=0) {
            firstAidAmt--;
            hp=maxHp;
            System.out.println("Életerő feltöltve");
       } else {
            System.out.println("Nem tudsz életerőt újratölteni! (Nincsen elsősegély dobozod.)");
        }
    }
    
    public void selectPlayerCast() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Válassz magadnak egy osztályt:");
        System.out.println("1.) Class1");
        System.out.println("  - Közelre jó");
        System.out.println("2.) Class2");
        System.out.println("  - Közelre és távolra jó, cserébe xy.");
        System.out.println("3.) Class3");
        System.out.println("  - Távolra jó");
        
        System.out.print("(1,2,3) > ");
        String choice = sc.nextLine();
        
        switch(choice){
                case "1":
                    this.hp = 150;
                    this.maxHp=150;
                    this.firstAidAmt = 2;
                    this.weapon = "Feszítővas";
                    this.dmg = 15;
                    break;
                
                case "2":
                    this.hp = 125;
                    this.maxHp= 125;
                    this.firstAidAmt = 1;
                    this.weapon = "Katana";
                    this.dmg = 20;
                    break;
                    
                case "3":
                    this.hp = 100;
                    this.maxHp=100;
                    this.firstAidAmt = 0;
                    this.weapon = "Íj";
                    this.dmg = 25;
                    break;
                    
                default:
                    break;
        }
    }
    
    public boolean checkHeal() {
        if(hp > hp*0.15) {
            return true;
        }
        return false;
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

    public int getStarvation() {
        return starvation;
    }

    public void setStarvation(int starvation) {
        this.starvation = starvation;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    
    

    @Override
    public String toString() {
        return "Player{" + "hp=" + hp + ", maxHp=" + maxHp + ", location=" + location + ", weapon=" + weapon + ", dmg=" + dmg + '}';
    }
    
}
