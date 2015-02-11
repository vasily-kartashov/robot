package com.kartashov.robot.rules;

import com.kartashov.robot.robot.Position;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.kartashov.robot.robot.Position.Orientation.*;
import static org.junit.Assert.*;

public class NoOverstepRuleTest {

    private static Rule rule;

    @BeforeClass
    public static void initRule() {
        rule = new NoOverstepRule(2, 2);
    }

    @Test
    public void testBounds() {
        assertFalse(rule.validate(null, null, new Position(-1, 0, WEST)));
        assertFalse(rule.validate(null, null, new Position(2, 0, WEST)));

        assertFalse(rule.validate(null, null, new Position(0, -1, WEST)));
        assertFalse(rule.validate(null, null, new Position(0, 2, WEST)));

        assertTrue(rule.validate(null, null, new Position(1, 0, WEST)));
        assertTrue(rule.validate(null, null, new Position(0, 1, WEST)));
        assertTrue(rule.validate(null, null, new Position(1, 1, WEST)));
    }

}
