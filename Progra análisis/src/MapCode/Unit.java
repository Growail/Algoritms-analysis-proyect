package MapCode;

import java.util.ArrayList;

public class Unit {
    
    private ArrayList <Drone> drones = new ArrayList <Drone>  ();
    private int lastStopDronesIndex; //Indice que separa los drones que no deben viajar a otra estacion despues de llegar y los que sí.
    private int arrivingTime;
    
    
    public void dischargeDronesCurrentStation(){
        
        for(int currentDrone = 0; currentDrone <= lastStopDronesIndex ; ++currentDrone){
            drones.remove(currentDrone); //LLegan a la estacion.
        }
    }
    
}
