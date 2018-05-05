package Simulation;
import MapCode.Drone;
import MapCode.Station;
import MapCode.Direction;
import GraphCode.Node;
import MapCode.Map;
import java.util.Random;
import logic.PlanDivideVenceras;

public class Simulator {
    
    private Map mainMap;
    private PlanDivideVenceras mainLogic;
    private int mainTimeClick;
    
    public Simulator(int stationQuantity, int stationArcs, int droneQuantity, int simulationSeconds){
        mainMap = new Map(stationQuantity, stationArcs);
        mainTimeClick = simulationSeconds;
        
        createDrones(droneQuantity, mainMap.getNodes(), stationQuantity);
    }
    
    private void createDrones(int droneQuantity, Node [] nodes, int stationQuntity){
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
