package GraphCode;

import MapCode.Drone;
import MapCode.Station;
import java.util.ArrayList;
import java.lang.Math;

/*
cada una de las instancias de esta clase son un vertice del grafo
cada vertice tiene una etiqueta para identificarlo de los demás
así se resuelve el posible problema de duplicados, por aquello,
el arraylist vecinity tiene los arcos conectados al vértice
*/


public class Node
{
 
    private String tag;
    private int[] axis;
    private int droneQuantity;
    private Station station;

    public Node (String tag, int[] axis)
    {
        station = new Station();
	this.tag = tag;
        
        this.axis = new int[2];
        this.axis[0] = axis[0];
        this.axis[1] = axis[1];
        
    }
    
    public double getDistance(Node otherNode){
        return Math.hypot(axis[0] - otherNode.getAxis(0), axis[1] - otherNode.getAxis(1));
    }
    
    /**
     * axisLetter 0 = X
     * axisLetter 1 = Y
     
     **/
    public int getAxis(int axisLetter){
        return this.axis[axisLetter];
    }
    /**
     * AÃ±ade un objeto Arc al arraylist vecinity
    si y solo si este no está ya adentro
     * @param arc. Objeto
     */

    public String getTag()
    {
	return this.tag;
    }

    /**
     * 
 * se comprueba si vertice2 en un nodo, entonces se le hace un instance of nodo para convertirlo y trabajarlo
 * después de eso se evelua si tiene el mismo valor que el nodo "actual", 
 * osea, el que llamó el metodo, para que sean iguales los tags deben ser iguales
 * pues no hay repetidos
     * @param vertice2. Objeto que comparamos con el nodo para 
     * evaluar si son el mismo objeto
     * @return true. Efectivamente son el mismo objeto
     */
    public boolean equals(Object vertice2)
    {
	if( !(vertice2 instanceof Node))
	    return false;

	Node v = (Node) vertice2;
	return this.tag.equals(v.tag);
    }

    public String toString()
    {
	return "Vertice: " + this.tag;
    }

    public void addDrone(Drone newDrone){
        station.addDrone(newDrone);
    }
    
    public Station getStation(){
        return station;
    }
}
