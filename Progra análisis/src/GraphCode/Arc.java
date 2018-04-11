package GraphCode;

/*
 * Un arc es una arista no dirijida
 * entre 2 nodos
 * si no se le da peso se le asigna 1
*/

public class Arc implements Comparable<Arc>
{
    private Node node1, node2;
    private int weight;

    /**
     * @param node1. de donde sale
     * @param node2. a donde llega
     **/
    public Arc(Node node1, Node node2)
    {
	this(node1, node2, 1);
    }

    /**
     * aqui se contruye la arista
     *
     * @param node1. nodo de salida
     * @param node2. nodo de llegada
     * @param weight. es la distancia
     * la parte que está comentada dentro del algoritmo es porque la idea
     * original era que un arco no pudiera ir a un nodo anterior
     * no se porqué pensé que era una buena idea
     * solo ignórelo
     **/
    public Arc(Node node1, Node node2, int weight)
    {
	/**if(node1.getTag().compareTo(node2.getTag()) <= 0)
	    {
		this.node1 = node1;
		this.node2 = node2;
	    }
	else
	    {**/
		this.node1 = node2;
		this.node2 = node1;
	   // }

     	this.weight = weight;
		
    }


    /** 
     * devuelve el nodo adyacente a el dado como parámetro
     * tienen que estar conectados por un arco
     *
     * @param actual
     * @return el nodo que está a la par, que esté conectado con un arco
     **/
    public Node getNeighbourNode(Node actual)
    {
	if (actual.equals(this.node1))
	    return this.node2;
	else if( actual.equals(this.node2))
	    return this.node1;
	else
	    return null;
    }


    public Node getNode1()
    {
	return this.node1;
    }
    
    
    public Node getNode2()
    {
	return this.node2;
    }

    public int getWeight()
    {
	return this.weight;
    }


    public void setWeight(int weight)
    {
	this.weight = weight;
    }

    /**
     * esto compara el pase de una arista, básicamente me da la diferencia entre una y la otra
     * es para saber si una es mas grande que otra
     * se usa la sobrecarga de operadores porque, por experiencia a nuñez le 
     * encanta eso
     * 
     * @param arista2. arco a comparar contra el actual, o con el que se está trabajando
     * @return int. Se devuelve 0 en caso de que ambas tengan el mismo peso
     **/
    public int compareTo(Arc arista2)
    {
	return this.weight - arista2.weight;
    }

    /**
     * el toString, para ir checkeando que todo vaya bien
     **/
    public String toString()
    {
	return "({" + this.node1 + ", " + this.node2  + "}, "+ this.weight  +")";
    }

    public int hashCode()
    {
	return (node1.getTag() + node2.getTag()).hashCode();
    }
    
    /**
 * compara el arista "actual" y otro, que es el parámetro, para saber si son iguales
 * osea, que los atributos de los 2 sean iguales, por eso el brete se lo echa la 
 * clase node y su propio metodo de equals
 * de nuevo, es una sobrecarga del operador ".equals"
     *
     * @param objeto. Se comprueba si es de tipo Arc. Y si lo es, se compara e identifica.
     * @return true. Si y solo si ambos objetos son iguales, osea que los extremos del arco son iguales
     **/
    public boolean equals(Arc objeto)
    {
	if(!(objeto instanceof Arc))
	    return false;

	Arc arista2 = (Arc) objeto;

	if(arista2.node1.equals(this.node1) && arista2.node2.equals(this.node2))
	    return true;

	return false;
    }
}
