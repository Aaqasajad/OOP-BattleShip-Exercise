import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private Board board;
    private List<Ship> ships;

    public Player(String name, int boardSize) {
        this.name = name;
        this.board = new Board(boardSize);
        this.ships = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }


    public void placeShip(Ship ship, int row, int col, boolean horizontal) {
        board.placeShip(ship, row, col, horizontal);
        ships.add(ship);
    }


    public boolean makeMove(Coordinate coordinate) {
        if (board.isHit(coordinate)) {
            board.markHit(coordinate);
            return true;
        } else {
            board.markMiss(coordinate);
            return false;
        }
    }


    public boolean hasSunkAllShips() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }
}
