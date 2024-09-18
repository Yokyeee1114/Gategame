package com.example.gategame.role;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hao Ye(u7981083)
 * Base model for all living life in this game.
 */
public class Role {

    private String name;
    private String description;
    private Integer power;
    private Integer health;
    private Integer maxHealth;

    public Role(String name, String description, Integer power, Integer maxHealth) {
        this.name = name;
        this.description = description;
        this.power = power;
        this.maxHealth = maxHealth;
        this.health = maxHealth; // full health at first
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPower() {
        return power;
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getMaxHealth() {
        return maxHealth;
    }

    public void setPower(Integer power) {
        this.power = power;
    }


    /**
     * Set the health value, can't exceed the limit.
     * @param health expected health
     */
    public void setHealth(Integer health) {
        if(health > maxHealth) {
            this.health = maxHealth;
        }else{
            this.health = health;
        }
    }

    /**
     * Whenever player raises his maxHealth, his health get full restored.
     * @param maxHealth raise maxHealth
     */
    public void setMaxHealth(Integer maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    /**
     *
     * @return the damage to attack enemies.
     */
    public Integer getDamage(){
        return power;
    }

    public boolean isAlive(){
        return health > 0;
    }

    public List<String> attack(Role opponent){
        List<String> result = new ArrayList<>();
        Integer damage = getDamage();
        opponent.setHealth(opponent.getHealth() - damage);
        result.add("%s attacked %s for %d damage.".formatted(name, opponent.name, damage));
        if(!opponent.isAlive()){
            result.add("%s has been defeated.".formatted(opponent.name));
        }else{
            result.add("%s has %s HP remaining".formatted(opponent.name, opponent.getHealth()));
        }
        return result;
    }

}
