import java.util.*;

public class Graph{
	private Set<Node> nodes = new HashSet<>();

	public void addNode(Node nodeA){
		nodes.add(nodeA);
	}
}

class Node{
	private String name;

	private List<Node> shortestPath = new LinkedList<>();

	private Integer distance = Integer.MAX_VALUE;

	Map<Node, Integer> adjacentNodes = new HashMap<>();

	public void addDestination(Node destination, int distance){
		adjacentNodes.put(destination, distance);
	}

	public Node(String name){
		this.name = name;
	}
}