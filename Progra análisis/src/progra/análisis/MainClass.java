/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra.análisis;

import GraphCode.Graph;
import GraphCode.Node;
import MapCode.Map;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class MainClass implements NodeTags{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        
        Scanner reader = new Scanner(System.in);
        Scanner reader2 = new Scanner(System.in); 
        System.out.println("Enter the amount of stations: ");
        int UserDesiredStations = reader.nextInt();
        System.out.println("Enter the amount of drones: ");
        int UserDesiredDrones = reader2.nextInt();
        reader.close();
        reader2.close();
        //int UserDesiredDrones = 15; 
        
        Graph DroneCounty = new Graph();
        int AmountOfStations;
        ArrayList<ArrayList> drones = new ArrayList<>();
                    
            if (UserDesiredStations < 3)
            {
                AmountOfStations = NodeTags.MINIMUM_AMOUNT_OF_STATIONS;
                System.out.println("Too few staions, new amount of stations: "+NodeTags.MINIMUM_AMOUNT_OF_STATIONS);
            }
            else
            {
                AmountOfStations = UserDesiredStations;
            }
            
        for(int i = 0; i < GRAPH_NODES.length; i++)
	    {
	    	NodeTags.GRAPH_NODES[i] = new Node(Character.toString(NodeTags.NODE_TAGS[i]));	
	    }
        
        for (int i = 0;i<GRAPH_NODES.length;i++)
        {
            if (i>=AmountOfStations)
            {
                GRAPH_NODES[i].setAvailable(Boolean.FALSE);
            }
        }
       
        Random randomNode1 = new Random();
        Random randomNode2 = new Random();
        Random randomDistance1 = new Random();
        Random randomDistance2 = new Random();
        Random randomOrigin = new Random();
        Random randomDestiny = new Random();
        ArrayList<Integer> element = new ArrayList<>();
        
         
        
        for(int j = 0; j<NodeTags.GRAPH_NODES.length; j++)
        {
            
            DroneCounty.insertArc(NodeTags.GRAPH_NODES[j], NodeTags.GRAPH_NODES
                    [randomNode1.nextInt(AmountOfStations-1)], Math.abs(randomDistance1
                            .nextInt(MAXIMUM_DISTANCE_BETWEEN_STATIONS)+NodeTags.
                                    MINIMUM_DISTANCE_BETWEEN_STATIONS));
            
            DroneCounty.insertArc(NodeTags.GRAPH_NODES[j], NodeTags.GRAPH_NODES
                    [randomNode2.nextInt(AmountOfStations-1)], Math.abs(randomDistance2
                            .nextInt(MAXIMUM_DISTANCE_BETWEEN_STATIONS)+NodeTags.
                                    MINIMUM_DISTANCE_BETWEEN_STATIONS));
            
            
        }
        
        DroneCounty.getArcs();
        
        for (int i = 0; i<UserDesiredDrones; i++)
        {
            element.add(randomOrigin.nextInt(AmountOfStations));
            element.add(randomDestiny.nextInt(AmountOfStations));
            drones.add(element);
            element = new ArrayList<>();
            System.out.println("Drone: "+i +", from "+randomOrigin.nextInt
                (UserDesiredStations)+" to "+randomDestiny.nextInt(UserDesiredStations));
        }

        
        /**for(int i = 0; i < NodeTags.GRAPH_NODES.length; i++)
	    {

		for( int k = 0; k < NodeTags.GRAPH_NODES[i].getNeighbourCount(); k++)
		    System.out.println(NodeTags.GRAPH_NODES[i].getNeighbour(k)); 
	    }**/
    }
    
}
