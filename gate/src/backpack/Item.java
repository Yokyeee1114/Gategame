package backpack;

import character.Role;

/**
 * @author Yeming Chen
 * item can help player gain stats or related to main functionality of the game
 */
public interface Item {
    String getName();
    void use(Role role);
}
