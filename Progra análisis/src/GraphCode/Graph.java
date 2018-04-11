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

    private HashMap<String, Node> nodes;
    private HashMap<Integer, Arc> arcs;

    /**
     * esto contruye el grafo pero esta vacio
     **/
    public Graph()
    {
	this.nodes = new HashMap<String, Node>();
	this.arcs = new HashMap<Integer, Arc>();
    }


    /**
     * esto construye un grafo usando una lista de nodos preconstruida como entrada
     * para llenar su propio arraylist de nodos
     *
     *@param nodes. Arraylist usado para llenar el grafo
     **/
    public Graph(ArrayList<Node> nodes)
    {
	this.nodes = new HashMap<String, Node>();
	this.arcs = new HashMap<Integer, Arc>();

	for(Node v : nodes )
	    {
		this.nodes.put(v.getTag(), v);
	    }
	
    }


    /**
 * inserta un arco entre los nodos v1 y v2, pero solo si no habia uno previo
     *
     * @param v1. Un extremo del arco
     * @param v2. Otro extremo del arco
     * @return true. Si el arco no existe previamente
     **/
    public boolean insertArc(Node v1, Node v2)
    {
      	return insertArc(v1, v2, 1);
    }

    
    /**
 * Inserta un arco entre v1 y v2 con un peso dado como parámetro
 * el arco se inserta siempre y cuando sea el único entre esos nodos y si 
 * v1 y v2 no son el mismo
     *
     * @param v1. Un extremo del arco
     * @param v2. Otro extremo del arco
     * @param peso. Coste para llegar de v1 a v2 
     * @return true. Si el arco no existe previamente
     **/
    public boolean insertArc(Node v1, Node v2, int peso)
    {
	if(v1.equals(v2)) //nodes identicos?
	    return false;

	Arc arc = new Arc(v1, v2, peso);

	if(arcs.containsKey(arc.hashCode())) //arc ya en el grafo?
	    return false;
	else if( v1.containsANeighbour(arc) || v2.containsANeighbour(arc)) //arc ya une a v1 o v2?
	    return false;

	arcs.put(arc.hashCode(), arc);
	v1.insertNeighbour(arc);
	v2.insertNeighbour(arc);
	return true;
    }

    /** 
     * @param arc. Arco que estamos buscando
     * @return true. Si el grafo contiene ese arc
     **/
    public boolean containsArc(Arc arc)
    {
	if(arc.getNode1() == null || arc.getNode2() == null)
	    return false;
	return this.arcs.containsKey(arc.hashCode());
    }


    /**
     * IMPORTANTE: si se elimina un arco se pierde la adyacencia entre nodos
     *
     *@param arc. Arc que se quiere eliminar del grafo
     *@return Arc. Arc borrada del grafo
     */
    public Arc deleteArc(Arc arc)
    {
	arc.getNode1().deleteNeighbour(arc);
	arc.getNode2().deleteNeighbour(arc);
	return this.arcs.remove(arc.hashCode());
    }

    /**
     * Retorna true si el nodo node se encuentra en el grafo
     * 
     * @param node. nodo que se busca
     * @return boolean. True si el nodo se encuentra.
     **/    
    public boolean containsNode(Node node)
    {
	return (this.nodes.get(node.getTag()) != null);
    }

    public Node getNode(String tag)
    {
	return this.nodes.get(tag);
    }

    /**
     * si el vertice que se va a insertar existe previamente, se consulta si existe permiso para
     * sobreescribirlo, si hay, se eliminan TODAS LAS ADYACENCIAS existentes
     *
     * @param node.
     * @param overwriteNode. Permiso para sobreescribir el nodo
     * @return boolean. Verdarero si el nodo se inserta con éxito
     **/
    public boolean insertNode(Node node, boolean overwriteNode)
    {
	Node actual = this.nodes.get(node.getTag());
	if(actual != null) //existía previamente?
	    {
		if(!overwriteNode)
		    return false;

		while(actual.getNeighbourCount() >= 0)
		    this.deleteArc(actual.getNeighbour(0));
		
	    }

	nodes.put(node.getTag(), node);
	return true;
    }

    /**
     * Elimina el vÃ©rtice especificado mediante la tag
 distintiva por parÃ¡metro de entrada. Al eliminar el vÃ©rtice
     * se elimina tambiÃ©n todas las adyancencias que poseÃ­a este.
     * IMPORTANTE: si se elimina un nodo, todos los arcos conectados a este SE
     * BORRAN TAMBIEN, esto para mantener consistencia
     *
     * @param tag.
     * @return Node. Devuelve el nodo eliminado
     **/
    public Node deleteNode(String tag)
    {
	Node node = nodes.remove(tag);

	while(node.getNeighbourCount() >= 0)
	    this.deleteArc(node.getNeighbour(0));

	return node;
    }

    public Set<String> verticeKeys()
    {
	return this.nodes.keySet();
    }

    public Set<Arc> getArcs()
    {
	return new HashSet<Arc>(this.arcs.values());
    }
    
}
