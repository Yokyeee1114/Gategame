import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;  // List to hold items

    public Inventory() {
        this.items = new ArrayList<>();
    }

    // Method to add an item to the inventory
    public void addItem(Item item) {
        if (items != null) {
            items.add(item);
            System.out.println("item " + item.getName() + " added");
            if (item.getType() == ItemType.WEAPON){
                Game.player.increaseAtk(item.getPower());
                System.out.println("user gain " + item.getPower() + " ATK");
            }
        }
    }

    // Method to use an item from the inventory
    public boolean useItem(int index) {
        Item item = items.get(index);
        if (items.contains(item) && item.getType() == ItemType.POTION) {
            items.remove(item);
            System.out.println("item " + item.getName() + " removed");
            item.use();
            return true;
        }
        return false;
    }

    // Method to view all items in the inventory
    public List<Item> getItems() {
        return new ArrayList<>(items);  // Returns a copy of the items list
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "items=" + items +
                '}';
    }
}

