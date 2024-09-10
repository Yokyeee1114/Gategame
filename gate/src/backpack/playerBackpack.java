package backpack;

import character.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yeming Chen
 * backpack for player, and add/use item inside
 */
public class playerBackpack implements Backpack {
    Role role;
    private Inventory inventory;
    private List<Item> items;


    public playerBackpack(Role role){
        this.role = role;
        this.items = new ArrayList<Item>();
    }

    @Override
    public void addItem(Item item){
        if (item != null) {
            items.add(item);
            System.out.println("item " + item.getName() + " added");
        }
    }

    @Override
    public boolean removeItem(int id) {
        if(id >= items.size()) return false;
        items.remove(id);
        return true;
    }

    public boolean useItem(int id) {
        if(id >= 0 && id < items.size()) {
            Item item = items.get(id);
            items.remove(id);
            System.out.println("item " + item.getName() + " removed");
            item.use(role);
            return true;
        }
        return false;
    }

    @Override
    public void displayItem() {
        System.out.println("playerBackpack{" +
                "character=" + role +
                ", items=" + items +
                '}');
    }

}
