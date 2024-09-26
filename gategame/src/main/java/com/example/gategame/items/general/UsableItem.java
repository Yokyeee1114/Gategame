package com.example.gategame.items.general;

import com.example.gategame.items.Item;
import com.example.gategame.role.Role;

/**
 * @author Yeming
 * usable Item is the kind of item can help player gain stats or beat enermy.
 * Which is different to main Item such as key.
 */
public interface UsableItem extends Item {
    void use(Role role);
    int getPower();

}
