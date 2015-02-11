package com.kartashov.robot;

import com.kartashov.robot.commands.CommandQueue;
import com.kartashov.robot.robot.Robot;
import com.kartashov.robot.rules.NoOverstepRule;
import com.kartashov.robot.rules.PlaceFirstRule;

import java.io.FileInputStream;
import java.io.InputStream;

public class Application {

    public static void main(String[] args) throws Exception {
        for (String path : args) {
            try (InputStream in = new FileInputStream(path)) {
                CommandQueue queue = new CommandQueue(in);
                Robot robot = new Robot();
                robot.execute(queue, new PlaceFirstRule(), new NoOverstepRule(5, 5));
            }
        }
    }
}
