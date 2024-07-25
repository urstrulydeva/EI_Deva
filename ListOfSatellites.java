package SatelliteCommandSystem;

import java.util.ArrayList;
import java.util.logging.Logger;
public class ListOfSatellites {
    private static final Logger logger = Logger.getLogger(Satellite.class.getName());
    int noOfSatellites;
    static int flag=0;
    ArrayList<Satellite> satellites= new ArrayList<>();
    public ListOfSatellites(int number)
    {
        this.noOfSatellites=number;
    }

    void add(Satellite sat)
    {
        if(flag<this.noOfSatellites) {
            satellites.add(sat);
            flag++;
            logger.info("New Satellite added");
        }
        else{
            logger.info("Create a new list");
        }
    }
    void listOfSatellites()
    {
        for(Satellite sat: this.satellites)
        {
            logger.info("Satellite:"+sat.ID);
        }
    }

}
