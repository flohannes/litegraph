/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package litegraph.graph;

/**
 *
 * @author Florian
 */
public class Arc extends GraphElement {

    private Vertex source;
    private Vertex destination;

    public enum Direction {
        BOTH, INCOMING, OUTGOING, LOOP;
    }
    
    public Arc(Vertex src, Vertex dest){
        this.source = src;
        this.destination = dest;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
    }
    
}
