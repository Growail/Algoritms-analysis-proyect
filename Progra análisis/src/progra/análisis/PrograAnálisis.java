/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra.análisis;
import GraphCode.Graph;
import MapCode.Map;
import java.util.ArrayList;

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
        
        int[][] arreglo;
        arreglo = new int[10][2];
        Graph G = new Graph(10,2,arreglo);
        G.calculate("A5", "A3");
        
    }
    
}
