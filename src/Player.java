public class Player {
    public String name;
    public Unit[] units;

    public Player(String name){
        this.name = name;
    }

    public void setUnits(Unit[] units) {
        this.units = units;
    }
}
