package GraphCode;

import java.util.*;

/* 
esta es la clase que modela un grafo no dirigidio usando una lista de adyacencia
en vez de una matriz, como las instrucciones decían.
tambien tiene metodos para el manejo de vertices y arcos y esas cosillas.
IMPORTANTE: 
vertices se distinguen por tags que son strings
un par dado de nodos solo puede tener un arco entre ellos para facilidad
Vocabulario:
nodo = vertice = node
vertice = arista = conexión = arc
 */

public class Graph{

    private Arc[] nodesArcs;
    private int[] arqQuantity;
    
    
    /**
     * esto contruye el grafo pero esta vacio
     **/
    public Graph(int nodeQuantity, int stationArcs, int[][] axisCoordinates)
    {
	nodesArcs = new Arc[nodeQuantity];
        arqQuantity = new int[nodeQuantity];
        
        
        //Creating the nodes
        Node[] nodes = new Node[nodeQuantity];
        
        char tag = 'A';
        int tagNumber = 0;
        int[] axsis = new int[2];
        
        for(int nodeNumber = 0 ; nodeNumber < nodeQuantity ; ++nodeNumber){
            ++tagNumber;
            
            axsis[0] = axisCoordinates[nodeNumber][0];
            axsis[1] = axisCoordinates[nodeNumber][1];
            
            nodes[nodeNumber] = new Node(tag + Integer.toString(tagNumber), axsis);
        }
        
        
        
        for(int nodeNumber = 0 ; nodeNumber < nodeQuantity; ++ nodeNumber){
            while(arqQuantity[nodeNumber] != stationArcs){
                for(int arcNumber = 0; arcNumber < nodeQuantity ; ++ arcNumber){
                    if(arqQuantity[arcNumber] == 0){
                        //une nodeNumer con arcNumber
                    }
                
                }
            }
        }
        
    }
    
    
    private int getNodeCount(int nodeIndex){
       return this.arqQuantity[nodeIndex];
    }
    
    public void startJourney(Node beginning, Node ending){
        
    }
    
    
}
