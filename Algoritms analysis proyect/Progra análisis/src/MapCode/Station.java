/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MapCode;

import java.util.ArrayList;

/**
 *
 * @author Steven
 */
public class Station {
    
    private String Tag;
    private ArrayList <Drone> parquedDrones = new ArrayList();
    
    public void addDrone(Drone newDrone){
        parquedDrones.add(newDrone);
    }
}
