public class Coordinate {
    private int row;
    private int col;

    public Coordinate(String coordinate) {
        this.row = Integer.parseInt(coordinate.substring(1));
        this.col = coordinate.charAt(0) - 'A';
    }

    public int getRow() { return row; }
    public int getCol() { return col; }


    public static boolean isValidCoordinate(String input) {
        if (input.length() != 2) return false;
        char col = input.charAt(0);
        char row = input.charAt(1);
        return (col >= 'A' && col <= 'J') && (row >= '0' && row <= '9');
    }

    @Override
    public String toString() {
        return "" + (char) ('A' + col) + row;
    }
}
