package role;

/**
 * A basic class for building roles with initial status: name, health, maxHealth, attack.
 * Status like health, maxHealth and attack can be changed.
 */
public class BasicRole {
    private final String name;
    private Integer health;
    private Integer attack;
    private Integer maxHealth;

    public BasicRole(String name, Integer attack, Integer maxHealth) {
        this.name = name;
        this.attack = attack;
        this.maxHealth = maxHealth;
        this.health = maxHealth; // full health at the start
    }


    public String getName() {
        return name;
    }

    public Integer getHealth() {
        return health;
    }

    /**
     * If the value exceeds max, use max instead.
     * @param health the updated health value
     */
    public void setHealth(Integer health) {
        if(health > maxHealth){
            this.health = maxHealth;
        }else{
            this.health = health;
        }
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(Integer maxHealth) {
        this.maxHealth = maxHealth;
    }
}
