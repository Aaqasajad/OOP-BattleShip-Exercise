public class Ship {
    private String name;
    private int size;
    private Coordinate[] coordinates;
    private int health;

    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
        this.health = size;
        this.coordinates = new Coordinate[size];
    }


    public void reduceHealth() {
        health--;
    }


    public boolean isSunk() {
        return health == 0;
    }


    public void setCoordinates(Coordinate[] coordinates) {
        this.coordinates = coordinates;
    }
}
