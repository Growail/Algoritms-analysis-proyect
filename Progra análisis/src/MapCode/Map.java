/*

 */
package MapCode;
import GraphCode.Graph;
import java.util.Random;
/**
 *
 * @author Kevin PC
 */
public class Map {
    
    Graph mainGraph;
    
    
    Map(int stationQuantity, int stationArcs){
     mainGraph = new Graph();
     createMap(stationQuantity, stationArcs);
    }
    
    void createMap(int stationQuantity, int stationArcs){
        
        Random randomNumber = new Random();
        
        for(int stationNumber = 0; stationNumber < stationQuantity ; ++ stationNumber){
            
        }
        
    }
}
