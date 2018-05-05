package MapCode;

import java.util.ArrayList;

public class Drone {
    
    private ArrayList <Direction> directions = new ArrayList<Direction>();
    
    public Drone(Direction mainDirection){
        
    }
    
    public Direction getCurrentDirection(){
        return directions.get(0);
    }
    
    public void nextDirection(){
        //Se puede optimizar
        directions.remove(0);
    }
    
}
