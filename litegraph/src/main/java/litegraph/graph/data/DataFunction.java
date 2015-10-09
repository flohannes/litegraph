/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package litegraph.graph.data;

import java.util.HashMap;
import java.util.Map;
import litegraph.graph.GraphElement;

/**
 *
 * @author Florian
 */
public class DataFunction<T> {

    private final Map<GraphElement, T> function;

    public DataFunction() {
        this.function = new HashMap<GraphElement, T>();
    }
    
    //output as json of entry T will be used as toString() Method.
}
