import java.util.concurrent.ThreadLocalRandom;

public class Unit {
    protected int health = 100;
    protected int defence = 100;
    protected int power = 10;
    protected int CritChance = 10;
    protected int ParryChance = 10;

    public int getHealth() {
        return health;
    }

    public int getDefence() {
        return defence;
    }

    public int getPower() {
        return power;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void attack(Unit unit) {
        if (Crit(CritChance)) {
            unit.getDamage(power * 1.05f);
        } else unit.getDamage(power);
    }

    public void getDamage(float damage) {
        if (Crit(ParryChance)) {
            this.health -= damage * 0.95f;
        } else
            this.health -= damage;
    }

    @Override
    public String toString() {
        return ", health=" + health +
                ", power=" + power;
    }

    public boolean Crit(int crit) {
        int chance = ThreadLocalRandom.current().nextInt(0, 100);
        if (chance <= crit) return true;
        return false;
    }
}
