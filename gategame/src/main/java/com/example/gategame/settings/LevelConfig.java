package com.example.gategame.settings;

import java.io.Serializable;

/**
 * @author Hao Ye(u7981083)
 */
public class LevelConfig implements Serializable {

    private String name;
    private GateConfig gate;
    private int level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GateConfig getGate() {
        return gate;
    }

    public void setGate(GateConfig gate) {
        this.gate = gate;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
