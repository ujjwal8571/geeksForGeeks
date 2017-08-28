package DataStructures.Graphs;

public class GraphClient {

	public static void main(String[] args) {

		Graph graph = new Graph();

		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);

		graph.addEdgeForUndirected(1, 2, 3);
		graph.addEdgeForUndirected(2, 3, 2);
		graph.addEdgeForUndirected(1, 4, 5);
		
		graph.bfsTraversal(2);
		
		

	}

}
