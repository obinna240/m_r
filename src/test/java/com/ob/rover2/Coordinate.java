package com.ob.rover2;

public class Coordinate {

    private final int x;
    private final int y;
    private static final int COORD_LIMIT = 11;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinate(int x, int y) {

        this.x = x % COORD_LIMIT;
        this.y = y % COORD_LIMIT;
    }
}
