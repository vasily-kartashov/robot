package com.kartashov.robot.commands;

import com.kartashov.robot.robot.Position;
import com.kartashov.robot.robot.Robot;
import com.kartashov.robot.rules.NoOverstepRule;
import com.kartashov.robot.rules.PlaceFirstRule;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CommandQueueTest {

    @Test
    public void testParser() throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("example1.txt");
        CommandQueue queue = new CommandQueue(in);
        Iterator<Command> iterator = queue.iterator();

        assertTrue(iterator.next() instanceof Place);
        assertTrue(iterator.next() instanceof Move);
        assertTrue(iterator.next() instanceof Left);
        assertTrue(iterator.next() instanceof Move);
        assertTrue(iterator.next() instanceof Move);
        assertTrue(iterator.next() instanceof Report);
        assertFalse(iterator.hasNext());

        Robot robot = new Robot(queue, new PlaceFirstRule(), new NoOverstepRule(5, 5));
        robot.execute();

        Position position = robot.getPosition();
        assertEquals(3, position.getX());
        assertEquals(0, position.getY());
        assertEquals(Position.Orientation.EAST, position.getOrientation());
    }
}
