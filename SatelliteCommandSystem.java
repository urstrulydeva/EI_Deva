package satellite;

import satellite.commands.*;

import java.util.Scanner;
import java.util.logging.Logger;

public class SatelliteCommandSystem {
    private static final Logger logger = Logger.getLogger(SatelliteCommandSystem.class.getName());
    private Satellite satellite;

    public SatelliteCommandSystem() {
        this.satellite = new Satellite();
    }

    public void executeCommand(String command, String parameter) {
        try {
            switch (command.toLowerCase()) {
                case "rotate":
                    new RotateCommand(satellite, parameter).execute();
                    break;
                case "activatepanels":
                    new ActivatePanelsCommand(satellite).execute();
                    break;
                case "deactivatepanels":
                    new DeactivatePanelsCommand(satellite).execute();
                    break;
                case "collectdata":
                    new CollectDataCommand(satellite).execute();
                    break;
                default:
                    logger.warning("Unknown command: " + command);
                    throw new IllegalArgumentException("Unknown command: " + command);
            }
        } catch (Exception e) {
            logger.severe("Error executing command: " + e.getMessage());
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Satellite Command System started");
        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                logger.info("Satellite Command System shutting down");
                break;
            }
            String[] parts = input.split("\\s+", 2);
            String command = parts[0];
            String parameter = parts.length > 1 ? parts[1] : null;
            executeCommand(command, parameter);
            System.out.println(satellite);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        SatelliteCommandSystem system = new SatelliteCommandSystem();
        system.run();
    }
}

