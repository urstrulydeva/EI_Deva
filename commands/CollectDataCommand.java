package satellite.commands;

import satellite.Satellite;

public class CollectDataCommand {
    private final Satellite satellite;

    public CollectDataCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    public void execute() {
        satellite.collectData();
    }
}

