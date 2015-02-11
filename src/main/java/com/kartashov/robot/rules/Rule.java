package com.kartashov.robot.rules;

import com.kartashov.robot.commands.Command;
import com.kartashov.robot.robot.Position;

public interface Rule {

    boolean validate(Command command, Position currentPosition, Position newPosition);
}
