package com.kartashov.robot.rules;

import com.kartashov.robot.commands.Command;
import com.kartashov.robot.commands.Place;
import com.kartashov.robot.robot.Position;

public class PlaceFirstRule implements Rule {

    public boolean validate(Command command, Position currentPosition, Position newPosition) {
        return currentPosition.placed() || command instanceof Place;
    }
}
