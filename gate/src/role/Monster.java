package role;

import backpack.Item;

import java.util.List;

/**
 * @author Hao Ye(u7981083)
 */
public class Monster extends Role {

    public Monster(String name, String description, Integer power, Integer maxHealth) {
        super(name, description, power, maxHealth);
    }

    public List<Item> dropLoot(){
        return null;
    }
}
