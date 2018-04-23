package GraphCode;

import java.util.ArrayList;

/*
cada una de las instancias de esta clase son un vertice del grafo
cada vertice tiene una etiqueta para identificarlo de los demás
así se resuelve el posible problema de duplicados, por aquello,
el arraylist vecinity tiene los arcos conectados al vértice
*/


public class Node
{
 
    private ArrayList<Arc> vecinity;
    private String tag;
    private Boolean available;

    public Node (String tag)
    {
	this.tag = tag;
	this.vecinity = new ArrayList<Arc>();
        available = true;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    
    /**
     * AÃ±ade un objeto Arc al arraylist vecinity
    si y solo si este no está ya adentro
     * @param arc. Objeto
     */
    
    public void insertNeighbour(Arc arc)
    {
	if( !this.vecinity.contains(arc))
	    this.vecinity.add(arc);
    }

    public boolean containsANeighbour(Arc arc)
    {
	return this.vecinity.contains(arc);
    }

    public Arc getNeighbour(int indice)
    {
	return this.vecinity.get(indice);
    }

    public Arc deleteNeighbour(int indice)
    {
	return this.vecinity.remove(indice);
    }
//aquí está el borrar de las 2 maneras, por indice y por arco, por aquello
    public void deleteNeighbour(Arc arista)
    {
	this.vecinity.remove(arista);
    }
    
    public int getNeighbourCount()
    {
	return this.vecinity.size();
    }

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

    public int hashCode()
    {
	return this.getTag().hashCode();
    }
    
    public ArrayList<Arc> getNeighbour()
    {
	return new ArrayList<Arc>(this.vecinity);
    }
}
