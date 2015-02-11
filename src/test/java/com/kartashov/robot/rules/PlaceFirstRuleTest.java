package com.kartashov.robot.rules;

import com.kartashov.robot.commands.Command;
import com.kartashov.robot.commands.Move;
import com.kartashov.robot.commands.Place;
import com.kartashov.robot.robot.Position;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.kartashov.robot.robot.Position.Orientation.NORTH;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlaceFirstRuleTest {

    private static Rule rule;

    @BeforeClass
    public static void initRule() {
        rule = new PlaceFirstRule();
    }

    @Test
    public void testSuccessfulPlacement() {
        Position currentPosition = new Position();
        Command command = new Place(new Position(1, 1, NORTH));
        Position newPosition = command.execute(currentPosition);

        assertTrue(rule.validate(command, currentPosition, newPosition));
    }

    @Test
    public void testUnsuccessfulMove() {
        Position currentPosition = new Position();
        Command command = new Move();

        assertFalse(rule.validate(command, currentPosition, null));
    }

    @Test
    public void testSuccessfulMove() {
        Position currentPosition = new Position(0, 0, NORTH);
        Command command = new Move();
        Position newPosition = command.execute(currentPosition);

        assertTrue(rule.validate(command, currentPosition, newPosition));
    }
}
