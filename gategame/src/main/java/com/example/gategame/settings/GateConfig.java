package com.example.gategame.settings;

import java.io.Serializable;

/**
 * @author Hao Ye(u7981083)
 */
public class GateConfig implements Serializable {

    private boolean isLocked;

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}
