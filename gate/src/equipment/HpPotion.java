package equipment;

import character.Role;

/**
 * @author Yeming Chen
 * Hp Potion is a kind of potion can restore player's hp
 */
public class HpPotion implements Potion{
    private String name;
    private int power;
    private int id;

    public HpPotion(int id, String name, int power) {
        this.id = id;
        this.name = name;
        this.power = power;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void use(Role role) {
        // player gain HP
        //character.increaseHP(power);
        System.out.println("You drink the " + name);
    }
}
