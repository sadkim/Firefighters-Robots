package Dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mapping.*;


public class Node {
	
	private Case nodeCase;

    private List<Node> shortestPath = new LinkedList<>();

    private long distance = Long.MAX_VALUE;

    Map<Node, Long> adjacentNodes = new HashMap<>();
    

    public Node(Case nodeCase) {
		this.nodeCase = nodeCase;
	}


	public Case getNodeCase() {
		return nodeCase;
	}


	public long getDistance() {
		return distance;
	}


	public void setShortestPath(List<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}


	public List<Node> getShortestPath() {
		return shortestPath;
	}


	public Map<Node, Long> getAdjacentNodes() {
		return adjacentNodes;
	}


	public void setDistance(long distance) {
		this.distance = distance;
	}


	public void addDestination(Node destination, long edgeWeigh) {
        adjacentNodes.put(destination, edgeWeigh);
    }

    

	
}
