package SatelliteCommandSystem;

public class Main {
    public static void main(String[] args) {
        ListOfSatellites s= new ListOfSatellites(10);
        Satellite sat=new Satellite();
        s.add(sat);
        Satellite sat1=new Satellite();
        s.add(sat1);
        sat.rotate("East");
        sat1.rotate("South");
        s.listOfSatellites();
        sat.activateSolarPanels();
        sat.setCollectedData();
        sat.satelliteDetails();


    }
}
