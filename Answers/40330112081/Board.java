public class Board {
    private char[][] grid;
    private int size;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '.';
            }
        }
    }


    public void placeShip(Ship ship, int row, int col, boolean horizontal) {
        Coordinate[] coordinates = new Coordinate[ship.getSize()];

        for (int i = 0; i < ship.getSize(); i++) {
            if (horizontal) {
                coordinates[i] = new Coordinate("" + (char) ('A' + col + i) + row);
                grid[row][col + i] = 'S';
            } else {
                coordinates[i] = new Coordinate("" + (char) ('A' + col) + (row + i));
                grid[row + i][col] = 'S';
            }
        }

        ship.setCoordinates(coordinates);
    }


    public boolean isHit(Coordinate coordinate) {
        int row = coordinate.getRow();
        int col = coordinate.getCol();
        return grid[row][col] == 'S';
    }


    public void markHit(Coordinate coordinate) {
        int row = coordinate.getRow();
        int col = coordinate.getCol();
        grid[row][col] = 'H';


    public void markMiss(Coordinate coordinate) {
        int row = coordinate.getRow();
        int col = coordinate.getCol();
        grid[row][col] = 'M';

    }


    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
