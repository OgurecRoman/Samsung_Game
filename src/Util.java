import java.util.Objects;
import java.util.Scanner;

public class Util {
    Game game;

    public Util(Game game){
        this.game = game;
    }

    public void generate_units(String[] units1, String[] units2) {
        Unit[] units_1 = new Unit[3];
        Unit[] units_2 = new Unit[3];
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(units1[i], "W")){ units_1[i] = new Wizard();}
            else if (Objects.equals(units1[i], "T")) units_1[i] = new Terminator();
            else units_1[i] = new Knight();
        }
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(units2[i], "W")) units_2[i] = new Wizard();
            else if (Objects.equals(units2[i], "T")) units_2[i] = new Terminator();
            else units_2[i] = new Knight();
        }
        game.players[0].setUnits(units_1);
        game.players[1].setUnits(units_2);
    }

    public void setPlayers() {
        Scanner in = new Scanner(System.in);
        System.out.print("Имя первого игрока: ");
        Player player1 = new Player(in.next());
        System.out.print("Имя второго игрока: ");
        Player player2 = new Player(in.next());
        Player[] players = new Player[]{player1, player2};

        game.setPlayers(players);
    }

    public void settings() {
        Scanner in = new Scanner(System.in);
        System.out.format("Приветствую вас, %s и %s, в игре %s!\n", game.players[0].name,
                game.players[1].name, game.nameGame);
        System.out.println("Вам предстоит сразиться в бою друг с другом.");
        System.out.println("Для начала создайте группу из 3х героев. " +
                "Можно выбрать Wizard (W), Knight (K) и Terminator (T).");
        System.out.println("Вводите героев в том порядке, в котором в " +
                "дальнейшем они будут сражаться");
        System.out.format("%s, выбор за вами: ", game.players[0].name);
        String a1 = in.next(), b1 = in.next(), c1 = in.next();
        System.out.format("%s, теперь вы: ", game.players[1].name);
        String a2 = in.next(), b2 = in.next(), c2 = in.next();

        this.generate_units(new String[]{a1, b1, c1}, new String[]{a2, b2, c2});

        System.out.println("Отлично! Все данный сохранены!");
        System.out.println("Счастливых вам Голодных Игр >:)");
    }

    public Player check_win(Player[] players) {
        for (int i = 0; i < 3; i++) {
            if (players[0].units[i].health <= 0) {
                return players[1];
            }
            if (players[1].units[i].health <= 0) {
                return players[0];
            }
        }
        return new Player("");
    }

    public void battle(int index, int round) {
        Player atacker = game.players[index];
        Player atack;
        if (index == 0) atack = game.players[1];
        else atack = game.players[0];

        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.format("---------- РАУНД %s ----------", round);
        System.out.println();
        System.out.println("Ход игрока " + atacker.name);
        System.out.println("Ваш персонаж: " + atacker.units[(round - 1) % 3]);
        System.out.println();

        System.out.println("Персонажи противника: ");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ") " + atack.units[i]);
        }

        System.out.println();
        System.out.println("Выберите, кому нанести урон (1, 2 или 3): ");
        int ind = in.nextInt() - 1;

        atacker.units[(round - 1) % 3].attack(atack.units[ind]);
        System.out.println("Урон нанесен!\n" + atack.units[ind]);
        System.out.println();
    }

    public void win(Player player) {
        System.out.println("Поздравляю! Игрок " + player.name + " выиграл!");
        System.out.println("Его персонажи:");
        for (int i = 0; i < 3; i++) {
            System.out.println((player.units[i]));
        }
        System.out.println();
    }

    public void lose(Player player) {
        System.out.println("К сожалению, Игрок " + player.name + " проиграл...");
        System.out.println("Его персонажи:");
        for (int i = 0; i < 3; i++) {
            System.out.println((player.units[i]));
        }
        System.out.println();
    }
}
