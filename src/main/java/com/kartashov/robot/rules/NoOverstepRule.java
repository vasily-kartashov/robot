package com.kartashov.robot.rules;

import com.kartashov.robot.commands.Command;
import com.kartashov.robot.robot.Position;
import com.kartashov.robot.robot.Robot;

public class NoOverstepRule implements Rule {

    private final int width;
    private final int height;

    public NoOverstepRule(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean validate(Command command, Position currentPosition, Position newPosition) {
        return 0 <= newPosition.getX()
                && newPosition.getX() < width
                && 0 <= newPosition.getY()
                && newPosition.getY() < height;
    }
}
