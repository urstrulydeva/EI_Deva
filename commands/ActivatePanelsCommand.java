package satellite.commands;

import satellite.Satellite;

public class ActivatePanelsCommand {
    private final Satellite satellite;

    public ActivatePanelsCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    public void execute() {
        satellite.activatePanels();
    }
}

