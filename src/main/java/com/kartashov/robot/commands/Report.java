package com.kartashov.robot.commands;

import com.kartashov.robot.robot.Position;

public class Report implements Command {

    @Override
    public Position execute(Position position) {
        System.out.println(position.toString());
        return position; // do not update the position
    }
}
