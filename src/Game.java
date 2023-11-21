public class Game {
    public String nameGame = "Подземелье";
    public int config;
    public Player[] players;
    public Util util = new Util(this);
    public Scenery scenery = new Scenery(util);


    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public void game(){
        while (scenery.State != 2){
            if (scenery.State == 0) scenery.settings();
            if (scenery.State == 1) scenery.battle(players);
        }
    }
}
