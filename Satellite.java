package SatelliteCommandSystem;
import java.util.*;
import java.util.logging.Logger;

public class Satellite {
    private static final Logger logger = Logger.getLogger(Satellite.class.getName());
    static int id=1;
    int ID;
    private String direction;
    private boolean activatedSolarPanels;
    private int collectedData;
    public Satellite()
    {
        this.ID=id;
        id++;
        this.direction="North";
        this.activatedSolarPanels=false;
        this.collectedData=0;
        logger.info("Satellite initialized with Orientation: North, Solar Panels: Inactive, Data Collected: 0");

    }
    void rotate(String direction)
    {
        this.direction=direction;
        logger.info("Satellite:"+ this.ID+" rotated to " + direction);
    }
    void activateSolarPanels()
    {
        this.activatedSolarPanels=true;
        logger.info("Satellite: " +this.ID+"Solar Panels: Active");
    }
    void setCollectedData()
    {
        if(this.activatedSolarPanels) {
            collectedData += 10;
            logger.info("Satellite data collected: " + collectedData);
        }
        else {
            logger.info("Activate the solar panels of Satellite"+this.ID+" to collect data");
        }
    }
    void satelliteDetails(){
        logger.info("Satellite initialized with Orientation: "+this.direction+", Solar Panels: "+ (activatedSolarPanels?"Active":"Inactive")+" ,Data Collected: "+this.collectedData);
    }

}
