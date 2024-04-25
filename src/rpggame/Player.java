
package rpggame;

public class Player {
    private int hp;
    private int maxHp;
    private String location;
    private String weapon;
    private int dmg;
    private int money;
    private int def;
    private boolean gotBoat;
    private int firstAidKitAmt;

    public Player(int hp, int maxHp, String location, String weapon, int dmg, int money, boolean gotBoat, int def, int firstAidKitAmt) {
        this.hp = 100;
        this.maxHp = 100;
        this.location = "WA";
        this.weapon = "Feszítővas";
        this.dmg = 10;
        this.money = 0;
        this.gotBoat = false;
        this.def = 0;
        this.firstAidKitAmt = 0;
    }
    
    public void heal() {
        if(firstAidKitAmt!=0) {
            firstAidKitAmt--;
            hp=maxHp;
            System.out.println("Életerő feltöltve");
       } else {
            System.out.println("Nem tudsz életerőt újratölteni! (Nincsen elsősegély dobozod.)");
        }
    }
    
    public boolean isAlive() {
        return hp>0;
    }

    public int getFirstAidKitAmt() {
        return firstAidKitAmt;
    }

    public void setFirstAidKitAmt(int firstAidKitAmt) {
        this.firstAidKitAmt = firstAidKitAmt;
    }
    
    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
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

    @Override
    public String toString() {
        return "Player{" + "hp=" + hp + ", maxHp=" + maxHp + ", location=" + location + ", weapon=" + weapon + ", dmg=" + dmg + '}';
    }
    
}
