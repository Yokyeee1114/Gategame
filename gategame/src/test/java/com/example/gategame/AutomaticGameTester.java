package com.example.gategame;
import com.example.gategame.Move.Location;
import com.example.gategame.backpack.Inventory;
import com.example.gategame.items.general.weapon.NormalWeapon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static com.example.gategame.Main.gameLoop;

public class AutomaticGameTester {

    String move1 ="d\n";

    String moveInvalid = "w\n";

    String openBag = "I\n";
    String chooseItem = "3\n";
    @Test
    void gameTester() throws InterruptedException {
        ByteArrayInputStream in = new ByteArrayInputStream(move1.getBytes());
        System.setIn(in);
        GameEngine.getInstance().loadEngine();
        Game game = new Game();
        game.initGame();
        game.getPlayer().getBackpack().addItem(Inventory.getInventory().createWeapon("Divine Rapier",350));
        game = gameLoop(game);
        Location location1 = game.getPlayerLocation();

        ByteArrayInputStream in2 = new ByteArrayInputStream(moveInvalid.getBytes());
        System.setIn(in2);
        game = gameLoop(game);
        Location location2 = game.getPlayerLocation();

        ByteArrayInputStream in3 = new ByteArrayInputStream(openBag.getBytes());
        System.setIn(in3);
        game = gameLoop(game);

        ByteArrayInputStream in4 = new ByteArrayInputStream(move1.getBytes());
        System.setIn(in4);
        game = gameLoop(game);
        Location location3 = game.getPlayerLocation();

        ByteArrayInputStream in5 = new ByteArrayInputStream(chooseItem.getBytes());
        System.setIn(in5);
        game = gameLoop(game);
        int power = game.getPlayer().getDamage();

        Assertions.assertEquals(new Location(1,2),location1);
        Assertions.assertEquals(new Location(1,2),location2);
        Assertions.assertEquals(new Location(1,2),location3);
        Assertions.assertEquals(380,power);
    }

}
