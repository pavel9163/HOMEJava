interface Health {
    int getCurrentHealth();
    int getMaxHealth();
}

interface Energy {
    int getCurrentEnergy();
    int getMaxEnergy();
}

class Building implements Health {
    private int currentHealth;
    private int maxHealth;

    public Building(int currentHealth, int maxHealth) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}

class Hero implements Health, Energy {
    private int currentHealth;
    private int currentEnergy;
    private int maxHealth;
    private int maxEnergy;

    public Hero(int currentHealth, int currentEnergy, int maxHealth, int maxEnergy) {
        this.currentHealth = currentHealth;
        this.currentEnergy = currentEnergy;
        this.maxHealth = maxHealth;
        this.maxEnergy = maxEnergy;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }
}

class NeutralCharacter implements Health {
    private int currentHealth;
    private int maxHealth;

    public NeutralCharacter(int currentHealth, int maxHealth) {
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}

class Render {
    public void showIndicator(Health healthObject) {
        if (healthObject instanceof Energy) {
            Energy energyObject = (Energy) healthObject;
            System.out.println("Energy: " + energyObject.getCurrentEnergy() + "/" + energyObject.getMaxEnergy());
        } else {
            System.out.println("Health: " + healthObject.getCurrentHealth() + "/" + healthObject.getMaxHealth());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Building building = new Building(80, 100);
        Hero hero = new Hero(90, 70, 100, 100);
        NeutralCharacter character = new NeutralCharacter(50, 80);

        Render render = new Render();
        render.showIndicator(building);
        render.showIndicator(hero);
        render.showIndicator(character);
    }
}
