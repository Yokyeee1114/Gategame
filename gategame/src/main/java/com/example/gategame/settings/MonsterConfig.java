package com.example.gategame.settings;

import com.example.gategame.role.MonsterType;

import java.io.Serializable;
import java.util.List;

/**
 * @author Hao Ye(u7981083)
 * Used to config monster properties
 */
public class MonsterConfig implements Serializable {

    private MonsterType type;
    // the types of items can be plundered
    private List<String> lootItems;
    // how many items can be plundered
    private Integer lootAmount;
    // the power of this type monster
    private Integer power;
    // the health of monster
    private Integer health;

    public MonsterType getType() {
        return type;
    }

    public void setType(MonsterType type) {
        this.type = type;
    }

    public List<String> getLootItems() {
        return lootItems;
    }

    public void setLootItems(List<String> lootItems) {
        this.lootItems = lootItems;
    }

    public Integer getLootAmount() {
        return lootAmount;
    }

    public void setLootAmount(Integer lootAmount) {
        this.lootAmount = lootAmount;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }
}
