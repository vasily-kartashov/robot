package com.kartashov.robot.robot;

import com.kartashov.robot.commands.Command;
import com.kartashov.robot.rules.Rule;

public class Robot {

    private final Rule[] rules;
    private Position position = new Position();

    public Robot(Rule... rules) {
        this.rules = rules;
    }

    public void execute(Iterable<Command> commands) {
        commands: for (Command command : commands) {
            Position newPosition = command.execute(position);
            for (Rule rule : rules) {
                if (!rule.validate(command, position, newPosition)) {
                    continue commands;
                }
            }
            position = newPosition;
        }
    }

    public Position getPosition() {
        return position;
    }
}
