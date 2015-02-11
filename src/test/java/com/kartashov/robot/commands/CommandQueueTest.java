package com.kartashov.robot.commands;

import com.kartashov.robot.robot.Position;
import com.kartashov.robot.robot.Robot;
import com.kartashov.robot.rules.NoOverstepRule;
import com.kartashov.robot.rules.PlaceFirstRule;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class CommandQueueTest {

    private Position execute(String example) throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream(example);
        CommandQueue queue = new CommandQueue(in);
        Robot robot = new Robot();
        robot.execute(queue, new PlaceFirstRule(), new NoOverstepRule(5, 5));
        return robot.getPosition();
    }

    @Test
    public void testExample1() throws IOException {
        Position position = execute("example1.txt");
        assertEquals(3, position.getX());
        assertEquals(0, position.getY());
        assertEquals(Position.Orientation.EAST, position.getOrientation());
    }

    @Test
    public void testExample2() throws IOException {
        Position position = execute("example2.txt");
        assertEquals(0, position.getX());
        assertEquals(1, position.getY());
        assertEquals(Position.Orientation.NORTH, position.getOrientation());
    }

    @Test
    public void testExample3() throws IOException {
        Position position = execute("example3.txt");
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
        assertEquals(Position.Orientation.WEST, position.getOrientation());
    }

    @Test
    public void testExample4() throws IOException {
        Position position = execute("example4.txt");
        assertEquals(3, position.getX());
        assertEquals(3, position.getY());
        assertEquals(Position.Orientation.NORTH, position.getOrientation());
    }
}
