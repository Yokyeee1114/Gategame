import java.util.ArrayList;
import java.util.List;
// sample game class for testing purpose, might need to modify later
public class Game {
    private static List<Item> availableItems = new ArrayList<>(); // all available item in the game
    static Character player = new Character("Hero", 10, 100);

    static {
        // add some test items
        availableItems.add(new Item("Small Healing Potion", ItemType.POTION, 5));
        availableItems.add(new Item("Medium Healing Potion", ItemType.POTION, 10));
        availableItems.add(new Item("Large Healing Potion", ItemType.POTION, 20));

        availableItems.add(new Item("Small Sword", ItemType.WEAPON, 3));
        availableItems.add(new Item("long Sword", ItemType.WEAPON, 5));
        availableItems.add(new Item("Big Sword", ItemType.WEAPON, 10));
    }

    public static List<Item> getAvailableItems() {
        return availableItems;
    }

    public static void main(String[] args) {
        System.out.println("test game start");
        System.out.println(player);
        player.getInventory().addItem(availableItems.get(4)); // get a long sword + 5 atk
        System.out.println(player);
        player.getInventory().addItem(availableItems.get(0)); // get a potion
        System.out.println(player);
        player.getInventory().useItem(1);
        System.out.println(player);
    }
}
