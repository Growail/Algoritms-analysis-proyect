/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphCode;

/**
 *
 * @author Steven
 */
public interface GraphConstants {
    int MINIMUM_DISTANCE_BETWEEN_NODES = 120; //Este es para asegurarse que la distancia entre nodos no sea algo tonto como 1
    int MAXIMUM_DISTANCE_BETWEEN_NODES = 1000;//Este es porque el "Random" estaba dando números muy grandes que ralentizaban el algoritmo
}
