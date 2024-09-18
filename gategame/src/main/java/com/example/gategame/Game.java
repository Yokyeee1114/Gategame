package com.example.gategame;

import com.example.gategame.backpack.Backpack;
import com.example.gategame.backpack.Inventory;
import com.example.gategame.backpack.PlayerBackpack;
import com.example.gategame.role.Role;
import com.example.gategame.role.Player;

// sample game class for testing purpose, might need to modify later
public class Game {
    Inventory inventory = Inventory.getInventory();

    public void initInventory(){
        // add some sample items
        inventory.createPotion("Small Healing Potion", 5);
        inventory.createPotion("Medium Healing Potion", 10);
        inventory.createPotion("Large Healing Potion", 20);
        inventory.createWeapon("Small Sword", 3);
        inventory.createWeapon("Long Sword", 5);
        inventory.createWeapon("Big Sword", 10);
        System.out.println(inventory);
    }


    public static void main(String[] args) {
        // test sample usage
        Game game = new Game();
        Role player = new Player("player", " ", 10, 100);
        game.initInventory();
        Inventory inventory = Inventory.getInventory();
        Backpack playerBackpack = new PlayerBackpack(player);
        inventory.addItemToBackpack(playerBackpack, 0); // add a potion
        playerBackpack.displayItem();
    }
}
