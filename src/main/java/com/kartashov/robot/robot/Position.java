package com.kartashov.robot.robot;

public class Position {

    public enum Orientation { NORTH, EAST, SOUTH, WEST, NONE }

    private final int x;
    private final int y;
    private final Orientation orientation;

    public Position() {
        this(-1, -1, Orientation.NONE);
    }

    public Position(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public boolean placed() {
        return orientation != Orientation.NONE;
    }

    public Position advance() {
        switch (orientation) {
            case NORTH:
                return new Position(x, y + 1, orientation);
            case EAST:
                return new Position(x + 1, y, orientation);
            case SOUTH:
                return new Position(x, y - 1, orientation);
            case WEST:
                return new Position(x - 1, y, orientation);
            case NONE:
            default:
                throw new IllegalStateException("The robot is not placed yet");
        }
    }

    public Position rotateClockwise() {
        switch (orientation) {
            case NORTH:
                return new Position(x, y, Orientation.EAST);
            case EAST:
                return new Position(x, y, Orientation.SOUTH);
            case SOUTH:
                return new Position(x, y, Orientation.WEST);
            case WEST:
                return new Position(x, y, Orientation.NORTH);
            case NONE:
            default:
                throw new IllegalStateException("The robot is not placed yet");
        }
    }

    public Position rotateCounterClockwise() {
        switch (orientation) {
            case NORTH:
                return new Position(x, y, Orientation.WEST);
            case EAST:
                return new Position(x, y, Orientation.NORTH);
            case SOUTH:
                return new Position(x, y, Orientation.EAST);
            case WEST:
                return new Position(x, y, Orientation.SOUTH);
            case NONE:
            default:
                throw new IllegalStateException("The robot is not placed yet");
        }
    }

    public String toString() {
        return String.format("(%d, %d, %s)", x, y, orientation);
    }
}
