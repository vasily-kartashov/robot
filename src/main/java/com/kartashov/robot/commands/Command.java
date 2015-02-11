package com.kartashov.robot.commands;

import com.kartashov.robot.robot.Position;

public interface Command {
    Position execute(Position position);
}
