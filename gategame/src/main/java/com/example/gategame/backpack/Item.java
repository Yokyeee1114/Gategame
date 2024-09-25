package com.example.gategame.backpack;

import com.example.gategame.control.Location;
import com.example.gategame.role.Role;

/**
 * @author Yeming Chen
 * item can help player gain stats or related to main functionality of the game
 */
public interface Item {
    String getName();
    void use(Role role);
    int getId();
    int getPower();
}
