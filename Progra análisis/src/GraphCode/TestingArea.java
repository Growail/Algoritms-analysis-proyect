package GraphCode;

import java.util.ArrayList;

/**   
 * Para checkear que todo funciona se hizo lo siguiente
 * se crean 6 nodos A,B,C,D,E,y F
 * se hacen arcos entre ellos, se conectan ABC y DEF y luego se conectan entre ellos
 * usando los nodos A y D, C y E y así quedan todos conectados
 */
public class TestingArea{
    public static void main (String [] args){
	Graph miGrafo = new Graph();

	Node [] vertices = new Node[6];
	char [] etiquetas = {'A','B','C','D','E','F'};
	int i = 0;
	boolean sobreescribe = true;
	
	for(i = 0; i < vertices.length; i++)
	    {
	    	vertices[i] = new Node(Character.toString(etiquetas[i]));
	     	System.out.println(vertices[i]);	    	
	    }

	System.out.println();

	miGrafo.insertArc(vertices[0], vertices[1], 3); // A -> B
	miGrafo.insertArc(vertices[0], vertices[2], 3); // A -> C
	miGrafo.insertArc(vertices[1], vertices[2], 1); // B -> C
	
	miGrafo.insertArc(vertices[3], vertices[4], 3); // D -> E
	miGrafo.insertArc(vertices[3], vertices[5], 3); // D -> F
	miGrafo.insertArc(vertices[4], vertices[5], 3); // E -> F

	miGrafo.insertArc(vertices[0], vertices[3], 3); // A -> D
	miGrafo.insertArc(vertices[2], vertices[4], 2); // C -> E

	//Sacamos las adyacencias de cada nodo
	for(i = 0; i < vertices.length; i++)
	    {
		System.out.println(vertices[i]);

		for( int k = 0; k < vertices[i].getNeighbourCount(); k++)
		    System.out.println(vertices[i].getNeighbour(k)); 
	    }

	//Eliminamos las adyacencias entre B <-> C
	
	for(Arc arista : vertices[1].getNeighbour())
	    {
		if(arista.getNode2().getTag().equals("C"))
		    miGrafo.deleteArc(arista);
	    }

	for(Arc arista : vertices[2].getNeighbour())
	    {
		if(arista.getNode2().getTag().equals("B"))
		    miGrafo.deleteArc(arista);
	    }

	//Y las adyacencias entre E <-> F
	
	/**for(Arc arista : vertices[4].getNeighbour())
	    {
		if(arista.getNode2().getTag().equals("E"))
		    miGrafo.deleteArc(arista);
	    }

	for(Arc arista : vertices[5].getNeighbour())
	    {
		if(arista.getNode2().getTag().equals("F"))
		    miGrafo.deleteArc(arista);
	    }
	*/
	
	System.out.println("Los vertices {B, C} tienen adyacencia: "
			   + miGrafo.containsArc(new Arc( vertices[1], vertices[2] ) ) );

	System.out.println("Los vertices {E, F} tienen adyacencia: "
			   + miGrafo.containsArc(new Arc (vertices[4], vertices[5] ) ) );

	
	
    }
}
