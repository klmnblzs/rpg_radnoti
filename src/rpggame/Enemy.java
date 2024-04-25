package rpggame;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Enemy {
    private String name;
    private int hp;
    private int maxHp;
    private int dmg;
    private int firstAidAmt;

    public Enemy(String name, int hp, int maxHp, int dmg, int firstAidAmt) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.dmg = dmg;
        this.firstAidAmt = firstAidAmt;
    }

    public static Enemy generateStats() {
        Random r = new Random();
        Enemy e = new Enemy(null, 0, 0, 0, 0);
        List<String> names = Arrays.asList("Paraszt", "Zombi", "Túlélő");

        int rndDmg = r.nextInt(12 - 7 + 1) + 7;
        int rndHp = r.nextInt(100 - 75) + 75;

        e.setHp(rndHp);
        e.setDmg(rndDmg);
        e.setName(names.get(r.nextInt(names.size())));

        return e;
    }

    public boolean checkHeal() {
        if(hp < maxHp*0.15) {
            return true;
        }
        return false;
    }

    public void heal() {
        if(firstAidAmt>0){
            hp=maxHp;
        }
    }

    /*
    public void generateEnemy() {
        Random r = new Random();
        
        int rndDmg = r.nextInt(12-7+1) + 7;
        int rndHp = r.nextInt(100-75) + 75;
        
        hp=rndHp;
        dmg=rndDmg;
    }
    */
    
    public boolean isAlive() {
        return hp > 0;
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

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Enemy{" + "hp=" + hp + ", maxHp=" + maxHp + ", dmg=" + dmg + '}';
    }

}