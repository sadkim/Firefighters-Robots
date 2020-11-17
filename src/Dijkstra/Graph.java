package Dijkstra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import mapping.Case;

public class Graph {

	private Map<Case, Node> nodes = new HashMap<>();

    public Graph(Map<Case, Node> nodes) {
		this.nodes = nodes;
	}
    
    public Map<Case, Node> getNodes() {
		return nodes;
	}

	public void addNode(Node nodeA) {
        nodes.put(nodeA.getNodeCase(), nodeA);
    }

}
