package satellite.commands;

import satellite.Satellite;

public class DeactivatePanelsCommand {
    private final Satellite satellite;

    public DeactivatePanelsCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    public void execute() {
        satellite.deactivatePanels();
    }
}
