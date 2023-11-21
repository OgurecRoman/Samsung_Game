public class Terminator extends Unit{
    public int power = 40;
    public int defence = 60;

    @Override
    public void attack(Unit unit) {
        super.attack(unit);
    }

    @Override
    public String toString() {
        return "Terminator{" +
                "health=" + health +
                '}';
    }
}
