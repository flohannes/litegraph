/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package litegraph.graph;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Florian
 */
public class Vertex extends GraphElement {

    private Collection<Arc> arcs;

    public Vertex() {
        arcs = new ArrayList<Arc>();
    }

    public void addArc(Arc a) {
        this.arcs.add(a);
    }

    public void removeArc(Arc a) {
        this.arcs.remove(a);
    }

    public Collection<Arc> getArcs() {
        return arcs;
    }

    public Collection<Arc> getArcs(Arc.Direction arcDirection) {
        switch (arcDirection) {
            case BOTH:
                return this.getArcs();
            case INCOMING:
                Collection incomingArcs = new ArrayList<Arc>();
                for (Arc arc : arcs) {
                    if (arc.getSource() == this) {
                        incomingArcs.add(arc);
                    }
                }
                return incomingArcs;
            case OUTGOING:
                Collection outgoingArcs = new ArrayList<Arc>();
                for (Arc arc : arcs) {
                    if (arc.getDestination() == this) {
                        outgoingArcs.add(arc);
                    }
                }
                return outgoingArcs;
            case LOOP:
                Collection loops = new ArrayList<Arc>();
                for (Arc arc : arcs) {
                    if (arc.getSource() == this && arc.getDestination() == this) {
                        loops.add(arc);
                    }
                }
                return loops;
            default:
                return null;
        }
    }

    public int getDegree() {
        int numOfLoops = 0;
        for (Arc a : arcs) {
            if (a.getSource() == this && a.getDestination() == this) {
                numOfLoops++;
            }
        }
        return this.arcs.size() + numOfLoops;
    }

    public int getOutDegree() {
        int degreeCounter = 0;
        for (Arc a : arcs) {
            if (a.getDestination() == this) {
                degreeCounter++;
            }
        }
        return degreeCounter;
    }

    public int getInDegree() {
        int degreeCounter = 0;
        for (Arc a : arcs) {
            if (a.getSource() == this) {
                degreeCounter++;
            }
        }
        return degreeCounter;
    }
}
