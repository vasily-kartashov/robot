package com.kartashov.robot.commands;

import com.kartashov.robot.robot.Position;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.kartashov.robot.robot.Position.Orientation;

public final class CommandQueue implements Iterable<Command> {

    private List<Command> commands = new ArrayList<>();

    public CommandQueue(InputStream in) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String upperCaseLine = line.toUpperCase();
                if (upperCaseLine.equals("LEFT")) {
                    commands.add(new Left());
                } else if (upperCaseLine.equals("MOVE")) {
                    commands.add(new Move());
                } else if (upperCaseLine.equals("REPORT")) {
                    commands.add(new Report());
                } else if (upperCaseLine.equals("RIGHT")) {
                    commands.add(new Right());
                } else if (upperCaseLine.startsWith("PLACE")) {
                    String[] tokens = upperCaseLine.split("[\\s,]");
                    try {
                        int x = Integer.parseInt(tokens[1]);
                        int y = Integer.parseInt(tokens[2]);
                        Orientation orientation = Orientation.valueOf(tokens[3]);
                        commands.add(new Place(new Position(x, y, orientation)));
                    } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                        System.err.println("Wrong format of place command");
                    }
                } else {
                    System.err.println("Unknown command '" + line + "'");
                }
            }
        }
    }

    public CommandQueue(Command... commands) {
        this.commands = Arrays.asList(commands);
    }

    @Override
    public Iterator<Command> iterator() {
        return commands.iterator();
    }
}
