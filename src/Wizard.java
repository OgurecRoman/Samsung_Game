public class Wizard extends Unit{

    private int mana = 100;
    public int power = 25;
    public int defence = 80;

    @Override
    public void attack(Unit unit) {
        mana -= 10;
        super.attack(unit);
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "mana='" + mana + '\'' +
                ", health=" + health +
                '}';
    }
}
