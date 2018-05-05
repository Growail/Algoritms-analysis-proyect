package Simulation;
import MapCode.Drone;
import MapCode.Station;
import MapCode.Direction;
import GraphCode.Node;
import java.util.Random;

public class Simulator {
    
    
    public void createDrones(int droneQuantity, Node [] nodes, int stationQuntity){
        
        /**
         * Crea las direcciones que deben seguir los drones.
         * Asigna esas direcciones a los drones.
         **/
        Random randomStationIndex = new Random();
        Direction [] allDirection = new Direction[droneQuantity];
        
        for(int currentDrone = 0; currentDrone <= droneQuantity ; ++currentDrone){
            int origin = randomStationIndex.nextInt(stationQuntity);
            int destination = randomStationIndex.nextInt(stationQuntity);
            
            while(origin == destination){
                origin = randomStationIndex.nextInt(stationQuntity);
                destination = randomStationIndex.nextInt(stationQuntity);
            }
            
            nodes[origin].addDrone(new Drone(new Direction(nodes[origin].getStation(), nodes[destination].getStation())));
            
        }
        
        
    }
    
    
}
