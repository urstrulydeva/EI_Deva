package satellite;
import java.util.logging.Logger;


public class Satellite {
    private static final Logger logger = Logger.getLogger(Satellite.class.getName());

    private String orientation;
    private boolean solarPanelsActive;
    private int dataCollected;

    public Satellite() {
        this.orientation = "North";
        this.solarPanelsActive = false;
        this.dataCollected = 0;
        logger.info("Satellite initialized with Orientation: North, Solar Panels: Inactive, Data Collected: 0");
    }

    public void rotate(String direction) {
        if (direction.equals("North") || direction.equals("South") || direction.equals("East") || direction.equals("West")) {
            this.orientation = direction;
            logger.info("Satellite rotated to " + direction);
        } else {
            logger.warning("Invalid direction provided: " + direction);
            throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }

    public void activatePanels() {
        this.solarPanelsActive = true;
        logger.info("Solar panels activated");
    }

    public void deactivatePanels() {
        this.solarPanelsActive = false;
        logger.info("Solar panels deactivated");
    }

    public void collectData() {
        if (this.solarPanelsActive) {
            this.dataCollected += 10;
            logger.info("Data collected. Total data collected: " + this.dataCollected + " units");
        } else {
            logger.warning("Attempted to collect data with inactive solar panels");
            throw new IllegalStateException("Solar panels must be active to collect data");
        }
    }

    @Override
    public String toString() {
        return "Satellite [Orientation=" + orientation + ", Solar Panels=" + (solarPanelsActive ? "Active" : "Inactive") + ", Data Collected=" + dataCollected + "]";
    }
}

