// sample class for testing purpose
public class Character {
    private String name;
    private Inventory inventory;
    private int atk;
    private int HP;

    public Character(String name, int atk, int HP) {
        this.name = name;
        this.inventory = new Inventory();
        this.atk = atk;
        this.HP = HP;
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }
    public int getAtk() {
        return atk;
    }
    public int getHP() {
        return HP;
    }

    public void increaseHP(int power){
        this.HP += power;
    }
    public void increaseAtk(int power){
        this.atk += power;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", inventory=" + inventory +
                ", atk=" + atk +
                ", HP=" + HP +
                '}';
    }
}