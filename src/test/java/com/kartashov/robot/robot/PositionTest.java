package com.kartashov.robot.robot;

import org.junit.Test;

import static com.kartashov.robot.robot.Position.Orientation.*;
import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void testAdvanceUp() {
        Position position = new Position(0, 0, NORTH);
        Position newPosition = position.advance();
        assertEquals(0, position.getY());
        assertEquals(1, newPosition.getY());
        assertEquals(NORTH, newPosition.getOrientation());
    }

    @Test
    public void testAdvanceRight() {
        Position position = new Position(0, 0, EAST);
        Position newPosition = position.advance();
        assertEquals(0, position.getX());
        assertEquals(1, newPosition.getX());
        assertEquals(EAST, newPosition.getOrientation());
    }

    @Test
    public void testAdvanceDown() {
        Position position = new Position(1, 1, SOUTH);
        Position newPosition = position.advance();
        assertEquals(1, position.getY());
        assertEquals(0, newPosition.getY());
        assertEquals(SOUTH, newPosition.getOrientation());
    }

    @Test
    public void testAdvanceLeft() {
        Position position = new Position(1, 1, WEST);
        Position newPosition = position.advance();
        assertEquals(1, position.getX());
        assertEquals(0, newPosition.getX());
        assertEquals(WEST, newPosition.getOrientation());
    }

    @Test
    public void testRotateClockwise() {

        Position position0 = new Position(1, 1, NORTH);

        Position position1 = position0.rotateClockwise();
        assertEquals(EAST, position1.getOrientation());

        Position position2 = position1.rotateClockwise();
        assertEquals(SOUTH, position2.getOrientation());

        Position position3 = position2.rotateClockwise();
        assertEquals(WEST, position3.getOrientation());

        Position position4 = position3.rotateClockwise();
        assertEquals(NORTH, position4.getOrientation());
    }

    @Test
    public void testRotateCounterClockwise() {

        Position position0 = new Position(1, 1, NORTH);

        Position position1 = position0.rotateCounterClockwise();
        assertEquals(WEST, position1.getOrientation());

        Position position2 = position1.rotateCounterClockwise();
        assertEquals(SOUTH, position2.getOrientation());

        Position position3 = position2.rotateCounterClockwise();
        assertEquals(EAST, position3.getOrientation());

        Position position4 = position3.rotateCounterClockwise();
        assertEquals(NORTH, position4.getOrientation());
    }
}
