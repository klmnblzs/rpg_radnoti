package rpggame;

public class Shop {
    // $100-al növekszik mindig
    // +5 dmg
    public static int weaponUpgrade = 100;
    // $200-al növekszik mindig
    // +5 hp
    public static int armorUpgrade = 150;
    public static int firstAidPrice = 500;
    public static int boatPrice = 10000;

    public static int getWeaponUpgrade() {
        return weaponUpgrade;
    }

    public static void setWeaponUpgrade(int weaponUpgrade) {
        Shop.weaponUpgrade = weaponUpgrade;
    }

    public static int getArmorUpgrade() {
        return armorUpgrade;
    }

    public static void setArmorUpgrade(int armorUpgrade) {
        Shop.armorUpgrade = armorUpgrade;
    }

    public static int getBoatPrice() {
        return boatPrice;
    }

    public static int getFirstAidPrice() {
        return firstAidPrice;
    }
}
