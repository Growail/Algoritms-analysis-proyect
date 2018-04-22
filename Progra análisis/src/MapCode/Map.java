

package MapCode;
import GraphCode.Graph;
import java.util.Random;

public class Map {
    
    Graph mainGraph;
    int [][] axisCoordinates;
    
    public Map(int stationQuantity, int stationArcs){
        createMap(stationQuantity, stationArcs);
        mainGraph = new Graph(stationQuantity, stationArcs,axisCoordinates);
        
    }
    
    private void createMap(int stationQuantity, int stationArcs){
        
        axisCoordinates = new int [stationQuantity][2];
        
        Random randomNumberAxis = new Random();
        
        
        for(int stationNumber = 0; stationNumber < stationQuantity ; ++ stationNumber){
            axisCoordinates[stationNumber][0] = randomNumberAxis.nextInt(500);
            axisCoordinates[stationNumber][0] = randomNumberAxis.nextInt(500);
        }
        
    }
    
    
    
}
