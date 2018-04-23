/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra.análisis;

import GraphCode.Node;

/**
 *
 * @author Steven
 */
public interface NodeTags {
    
    Node [] GRAPH_NODES = new Node[30];
    char [] NODE_TAGS = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
    'O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d'};
    int MINIMUM_DISTANCE_BETWEEN_STATIONS = 120;
    int MAXIMUM_DISTANCE_BETWEEN_STATIONS = 1200;
    int MINIMUM_AMOUNT_OF_STATIONS = 3;
    
}
