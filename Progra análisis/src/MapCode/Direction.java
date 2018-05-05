package MapCode;

public class Direction {
    private Station origin;
    private Station destiny;
    
    public Direction(Station origin, Station destiny){
        this.origin = origin;
        this.destiny = destiny;
    }
    
    public int getDirectionLength(int currentTime){
        double length = origin.getDistance(destiny);
        int realTime = (int)length/120 + currentTime;
        return realTime;
    }
}
