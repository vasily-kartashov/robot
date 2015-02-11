package com.kartashov.robot.commands;

import com.kartashov.robot.robot.Position;

public class Place implements Command {

    private final Position position;

    public Place(Position position) {
        this.position = position;
    }

    @Override
    public Position execute(Position position) {
        return this.position;
    }
}
