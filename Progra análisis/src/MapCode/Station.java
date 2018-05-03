package MapCode;

import java.util.ArrayList;

public class Station {
    private String tag;
    private ArrayList <Drone> parquedDrones = new ArrayList();
    
    public void addDrone(Drone newDrone){
        parquedDrones.add(newDrone);
    }
}
