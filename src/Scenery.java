public class Scenery {
    public int State = 0;
    public int round = 1;

    public Util util;

    public Scenery(Util util){
        this.util = util;
    }

    public void settings(){
        util.setPlayers();
        util.settings();
        State++;
    }

    public void battle(Player[] players){
        if (round % 2 == 0) util.battle(1, round);
        else util.battle(0, round);
        round++;
        Player win = util.check_win(players);
        Player lose;
        if (win == players[0]) lose = players[1];
        else lose = players[0];
        if (win.name != ""){
            util.win(win);
            util.lose(lose);
            State++;
        }
    }
}
