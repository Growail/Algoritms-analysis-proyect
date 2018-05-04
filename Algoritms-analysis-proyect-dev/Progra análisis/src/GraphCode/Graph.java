package GraphCode;

import static java.lang.Math.abs;
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
    private Node[] nodes;
    
    
    /**
     * esto contruye el grafo pero esta vacio
     **/
    public Graph(int nodeQuantity, int stationArcs, int[][] axisCoordinates)
    {
	nodesArcs = new Arc[nodeQuantity*stationArcs];
        arqQuantity = new int[nodeQuantity];
        
        
        //Creating the nodes
        nodes = new Node[nodeQuantity];
        
        String tag = "A";
        int tagNumber = 0;
        int[] axsis = new int[2];
        
        for(int nodeNumber = 0 ; nodeNumber < nodeQuantity ; nodeNumber++){
            ++tagNumber;
            
            axsis[0] = axisCoordinates[nodeNumber][0];
            axsis[1] = axisCoordinates[nodeNumber][1];
            
            nodes[nodeNumber] = new Node(tag + Integer.toString(tagNumber), axsis);
            
            System.out.println("Nodo "+tag + Integer.toString(tagNumber)+" insertado");
            System.out.println("");
        }
        
        for (int nodesCont = 0; nodesCont<nodeQuantity; nodesCont++)
        {
            Random randomNode1 = new Random();
            Random randomNode2 = new Random();
            Random randomWeight = new Random();
            
            int randomDestination, randomDestination2;
            
            randomDestination = randomNode1.nextInt(nodeQuantity);
            randomDestination2 = randomNode2.nextInt(nodeQuantity);
            System.out.println(randomDestination+ " random 1");
            System.out.println(randomDestination2+ " random 2");
            
            if(randomDestination2 == randomDestination || randomDestination2 == 0)
            {
                if(randomDestination2 == 0)
                {
                    randomDestination2 = nodeQuantity;
                }
                else
                {
                    randomDestination2-=1;
                }
            }
                    
            Arc newarc1 = new Arc(nodes[nodesCont], 
                    nodes[randomDestination], abs(randomWeight.nextInt(1000)+120));
            
            Arc newarc2 = new Arc(nodes[nodesCont], 
                    nodes[randomDestination2], abs(randomWeight.nextInt(1000)+120));
            
            if(newarc1.getNode1() != null)
            {
                nodesArcs[nodesCont] = newarc1;
                System.out.println(nodesArcs[nodesCont]);
            }
            if (newarc2.getNode1() != null)
            {
                nodesArcs[nodesCont+1] = newarc2;
                System.out.println(nodesArcs[nodesCont+1]);
            }
            
            
            
        }
        
        /**for(int nodeNumber = 0 ; nodeNumber < nodeQuantity; nodeNumber++){
            while(arqQuantity[nodeNumber] != stationArcs){
                for(int arcNumber = 0; arcNumber < nodeQuantity ; arcNumber++){
                    if(arqQuantity[arcNumber] != 0){
                        //une nodeNumer con arcNumber
                        System.out.println("we");
                    }
                
                }
            }
        }**/
        
    }
    
    public void calculate (String sourceTag, String destinyTag)
    {
        System.out.println("Djikstra");
        for(int pointerNodes = 0; pointerNodes<nodes.length; pointerNodes++)
        {
            nodes[pointerNodes].setVisited(false);
        }
        Node source = null;
        Node destiny = null;
        
        for(int pointerNodes = 0; pointerNodes<nodes.length; pointerNodes++)
        {
            if (nodes[pointerNodes].getTag().equals(sourceTag)){
                source = nodes[pointerNodes];
                System.out.println("Nodo origen: "+nodes[pointerNodes].getTag());
                
            }
        }
        for(int pointerNodesDestiny = 0; pointerNodesDestiny<nodes.length; pointerNodesDestiny++)
        {
            if (nodes[pointerNodesDestiny].getTag().equals(destinyTag)){
                destiny = nodes[pointerNodesDestiny];
                System.out.println("Nodo destino: "+nodes[pointerNodesDestiny].getTag());
            }
        }
        ArrayList queue = new ArrayList();
        int distance;
        Boolean AvailablePath = true;
        
        System.out.println(nodesArcs.length+" size");
        while(!source.equals(destiny))
        {
            System.out.println(source.getTag() + " sourceTag");
            System.out.println(destiny.getTag()+" destinyTag");
            try{
             for(int pointerLastNode = 0; pointerLastNode < nodesArcs.length; pointerLastNode++)
             {
                 System.out.println(pointerLastNode+"  cntador ");
                 
                 if(nodesArcs[pointerLastNode].getNode1()== source)
                 {
                     if(nodesArcs[pointerLastNode].getNode1()== source)
                     {
                         if (nodesArcs[pointerLastNode].getNode2().getVisited() == false)
                         {
                         source = nodesArcs[pointerLastNode].getNode2();
                         System.out.println(nodesArcs[pointerLastNode].getNode2().getTag()+" new source");
                         nodesArcs[pointerLastNode].getNode2().setVisited(true);
                         queue.add(nodesArcs[pointerLastNode]);
                         pointerLastNode = 0;
                         System.out.println(nodesArcs[pointerLastNode].toString());
                         }
                         else
                         {
                             System.out.println("exit 1");
                             AvailablePath = false;
                             break;
                         }
                     }
                  else if (nodesArcs[pointerLastNode].getNode2()== source)
                     {
                         if (nodesArcs[pointerLastNode].getNode1().getVisited() == false)
                         {
                         source = nodesArcs[pointerLastNode].getNode1();
                         System.out.println(nodesArcs[pointerLastNode].getNode1().getTag()+" new source");
                         nodesArcs[pointerLastNode].getNode1().setVisited(true);
                         queue.add(nodesArcs[pointerLastNode]);
                         pointerLastNode = 0;
                         System.out.println(nodesArcs[pointerLastNode].toString());
                         }
                         else
                         {
                             System.out.println("exit 2");
                             AvailablePath = false;
                             break;
                         }
                     }
                 }
             }
            }
            catch(Exception e)
            {
                System.out.println("Exit 3");
                AvailablePath = false;
                System.out.println(source.getTag()+" tag al momento de la caida");
                break;
            }
        }
        
        System.out.println(source.getTag() + " sourceTag");
        System.out.println(destiny.getTag()+" destinyTag");
        if (AvailablePath = false || queue.size() == 0)
        {
            System.out.println("NO available path conecting source and destiny");
        }
        else
        {
         System.out.println(queue.size()+" queue");
         for(int arcPointer = 0; arcPointer<queue.size(); arcPointer++)   
         {
             System.out.println(queue.get(arcPointer).toString());
         }
        }
        
    }
    
    
    private int getNodeCount(int nodeIndex){
       return this.arqQuantity[nodeIndex];
    }
    
    
    
    public void startJourney(Node beginning, Node ending){
        
    }
    
    public void backtrackingAlgorithm (int[] sizes, Node beginning, Node ending){
        
    }
    
    
}
