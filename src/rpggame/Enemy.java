package rpggame;

import java.util.Random;

public class Enemy {
    private int hp;
    private int maxHp;
    private int dmg;

    public Enemy(int hp, int maxHp, int dmg) {
        this.hp = hp;
        this.maxHp = maxHp;
        this.dmg = dmg;
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

    @Override
    public String toString() {
        return "Enemy{" + "hp=" + hp + ", maxHp=" + maxHp + ", dmg=" + dmg + '}';
    }

}