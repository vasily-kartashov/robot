package com.kartashov.robot.commands;

import com.kartashov.robot.robot.Position;

public class Move implements Command {

    @Override
    public Position execute(Position position) {
        return position.advance();
    }
}
