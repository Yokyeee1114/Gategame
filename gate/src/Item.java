public class Item {
    private String name;
    private ItemType type;  // potion, weapon
    private int power;

    public Item(String name, ItemType type, int power) {
        this.name = name;
        this.type = type;
        this.power = power;
    }

    public void use() {
        switch (type) {
            case POTION:
                Game.player.increaseHP(this.power);
                System.out.println("You drink the " + name);
                break;
            case WEAPON:
                System.out.println("WEAPON: " + name + "is not consumable");
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", power=" + power +
                '}';
    }
}

