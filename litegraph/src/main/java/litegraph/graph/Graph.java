/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package litegraph.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import litegraph.graph.data.DataFunction;

/**
 *
 * @author Florian
 */
//TODO: Was ist mit Daten, die den Graphen naeher beschreiben??
public class Graph {

    private final Map<String, DataFunction> functions;
    private final Collection<Vertex> vertices;
    private final Collection<Arc> arcs;

    public Graph() {
        vertices = new ArrayList<Vertex>();
        arcs = new ArrayList<Arc>();
        functions = new HashMap<String, DataFunction>();
    }

    public void addVertex(Vertex v) {
        this.vertices.add(v);
    }

    public void removeVertex(Vertex v) {
        this.vertices.remove(v);
    }

    public Collection<Vertex> getVertices() {
        return vertices;
    }

    public void addArc(Vertex src, Vertex dest) {
        Arc a = new Arc(src, dest);
        this.arcs.add(a);
        src.addArc(a);
        dest.addArc(a);
    }

    public void removeArc(Arc a) {
        a.getSource().removeArc(a);
        a.getDestination().removeArc(a);
        this.arcs.remove(a);
    }

    public Collection<Arc> getArcs() {
        return arcs;
    }

    public void addFunction(String identifierLabel, DataFunction function){
        this.functions.put(identifierLabel, function);
    }
    
    public void removeFunction(String identifierLabel){
        this.functions.remove(identifierLabel);
    }
    
    public DataFunction getFunction(String label){
        return this.functions.get(label);
    }
}
