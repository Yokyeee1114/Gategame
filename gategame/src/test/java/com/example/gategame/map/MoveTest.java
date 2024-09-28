package com.example.gategame.map;

import com.example.gategame.Move.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveTest {
    @Test
    public void testMove() {
        Location location = new Location(3,3);
        Assertions.assertEquals(new Location(3,2),location.moveA());
        Assertions.assertEquals(new Location(3,4),location.moveD());
        Assertions.assertEquals(new Location(2,3),location.moveW());
        Assertions.assertEquals(new Location(4,3),location.moveS());
    }
}
