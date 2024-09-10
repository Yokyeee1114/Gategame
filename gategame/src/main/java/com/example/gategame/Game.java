package com.example.gategame;

import com.example.gategame.backpack.Backpack;
import com.example.gategame.backpack.Inventory;
import com.example.gategame.backpack.playerBackpack;
import com.example.gategame.role.Role;
import com.example.gategame.role.Player;

// sample game class for testing purpose, might need to modify later
public class Game {
    Inventory inventory = Inventory.getInventory();

    public void initInventory(){
        // add some sample items
        inventory.createPotion(0,"Small Healing Potion", 5);
        inventory.createPotion(1,"Medium Healing Potion", 10);
        inventory.createPotion(2,"Large Healing Potion", 20);
        inventory.createWeapon(3,"Small Sword", 3);
        inventory.createWeapon(4,"Long Sword", 5);
        inventory.createWeapon(5,"Big Sword", 10);
        System.out.println(inventory);
    }


    public static void main(String[] args) {
        // test sample usage
        Game game = new Game();
        Role player = new Player("player", " ", 10, 100);
        game.initInventory();
        Inventory inventory = Inventory.getInventory();
        inventory.registerBackpack("playerBag", new playerBackpack(player)); //register a backpack
        inventory.addItemToBackpack("playerBag", 0); // add a potion
        System.out.println(inventory);
        Backpack backpack = inventory.getBackpacks("playerBag");
        backpack.displayItem();
    }
}
