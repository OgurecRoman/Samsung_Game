public class Knight extends Unit {
    public int power = 20;
    public int defence = 100;

    @Override
    public void attack(Unit unit) {
        super.attack(unit);
    }

    @Override
    public String toString() {
        return "Knight{" +
                "health=" + health +
                '}';
    }
}
