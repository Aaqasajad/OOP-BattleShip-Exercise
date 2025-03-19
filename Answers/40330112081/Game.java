import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Scanner scanner;

    public Game(String player1Name, String player2Name, int boardSize) {
        player1 = new Player(player1Name, boardSize);
        player2 = new Player(player2Name, boardSize);
        scanner = new Scanner(System.in);
    }

    public void start() {

        System.out.println("game started!");
        while (true) {
            if (playTurn(player1, player2)) {
                break;
            }
            if (playTurn(player2, player1)) {
                break;
            }
        }
        System.out.println("game done!");
    }


    private boolean playTurn(Player currentPlayer, Player opponent) {
        System.out.println(currentPlayer.getName() + "'turn s");
        currentPlayer.getBoard().display();

        System.out.println("enter the target ");
        String input = scanner.nextLine();
        while (!Coordinate.isValidCoordinate(input)) {
            System.out.println("invalid target , try again ");
            input = scanner.nextLine();
        }
        Coordinate target = new Coordinate(input);
        boolean hit = currentPlayer.makeMove(target);

        if (hit) {
            System.out.println("hit!");
        } else {
            System.out.println("miss!");
        }

        if (opponent.hasSunkAllShips()) {
            System.out.println(currentPlayer.getName() + " wone!");
            return true;
        }
        return false;
    }
}