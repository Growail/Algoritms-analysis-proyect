/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra.análisis;
import GraphCode.Node;
import MapCode.Drone;
import MapCode.Map;
import Simulation.Simulator;

/**
 *
 * @author Steven
 */
public class PrograAnálisis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Simulator a = new Simulator();
        
        int stationQuantity = 10;
        int droneQuantity = 1000;
        
        Node[] nodes = new Node[stationQuantity];
        int[] b = new int[2];
        
        for(int i = 0; i<stationQuantity ; ++i){
            nodes[i] = new Node("", b);
        }
        
        //a.createDrones(droneQuantity, nodes, stationQuantity);
        
        
    }
    
}
