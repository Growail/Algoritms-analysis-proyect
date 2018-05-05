package MapCode;

import java.util.ArrayList;

public class Station {
    private String tag;
    private ArrayList <Drone> parquedDrones = new ArrayList();
    private int[] axis;
    
    
    public Station(String tag, int[] axis){
        this.tag = tag;
        this.axis[0] = axis[0];
        this.axis[1] = axis[1];
    }
    
    public int getAxis(int axisDirection){
        return axis[axisDirection];
    }
    
    public void addDrone(Drone newDrone){
        parquedDrones.add(newDrone);
    }
    
    public double getDistance(Station otherStation){
        return Math.hypot(axis[0] - otherStation.getAxis(0), axis[1] - otherStation.getAxis(1));
    }
}
