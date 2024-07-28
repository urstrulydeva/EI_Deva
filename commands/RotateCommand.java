package satellite.commands;

import satellite.Satellite;

public class RotateCommand {
    private final Satellite satellite;
    private final String direction;

    public RotateCommand(Satellite satellite, String direction) {
        this.satellite = satellite;
        this.direction = direction;
    }

    public void execute() {
        satellite.rotate(direction);
    }
}
