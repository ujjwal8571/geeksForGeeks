package DataStructures.Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class Graph {

	private class Vertex {

		int vname;
		HashMap<Integer, Integer> neighbours = new HashMap<>(); // map for neighbours and their weight

		public Vertex(int vname) {
			this.vname = vname;
		}

	}

	private HashMap<Integer, Vertex> vertices = new HashMap<>();

	public void addVertex(int vtx) {

		if (vertices.containsKey(vtx)) {
			return;
		}

		vertices.put(vtx, new Vertex(vtx));

	}

	public void addEdgeForUndirected(int vtx1Name, int vtx2Name, int weight) {

		Vertex vtx1 = vertices.get(vtx1Name);
		Vertex vtx2 = vertices.get(vtx2Name);

		if (vtx1 == null || vtx2 == null) {
			return;
		}

		vtx1.neighbours.put(vtx2Name, weight);
		vtx2.neighbours.put(vtx1Name, weight);

	}

	public void addEdgeForDirected(int vtx1Name, int vtx2Name, int weight) {

		Vertex vtx1 = vertices.get(vtx1Name);
		Vertex vtx2 = vertices.get(vtx2Name);

		if (vtx1 == null || vtx2 == null) {
			return;
		}

		vtx1.neighbours.put(vtx2Name, weight);

	}

	public void display() {

		Set<Integer> vertices = this.vertices.keySet();

		for (Integer vertice : vertices) {

			String str = "";
			str += vertice + "=>";

			Set<Integer> neighbours = this.vertices.get(vertice).neighbours.keySet();

			for (Integer neighbour : neighbours) {
				str += neighbour + "[" + this.vertices.get(vertice).neighbours.get(neighbour) + "],";

			}

			System.out.println(str + ".");

		}

	}

	public void bfsTraversal(int vname) {

		LinkedList<Vertex> queue = new LinkedList<>();
		HashMap<Vertex, Boolean> isProcessed = new HashMap<>();

		Vertex vtx = this.vertices.get(vname);
		queue.add(vtx);
		isProcessed.put(vtx, true);

		while (!queue.isEmpty()) {

			Vertex removed = queue.removeFirst();
			System.out.print(removed.vname+" ");

			Set<Integer> neighbours = removed.neighbours.keySet();

			for (Integer neighbour : neighbours) {
				Vertex neigh = this.vertices.get(neighbour);

				if (!isProcessed.containsKey(neigh)) {

					queue.addLast(neigh);
					isProcessed.put(neigh, true);
				}

			}

		}

	}

	public void dfsTraversal(int vname) {

		LinkedList<Vertex> stack = new LinkedList<>();
		HashMap<Vertex, Boolean> isProcessed = new HashMap<>();

		Vertex vtx = this.vertices.get(vname);
		stack.addFirst(vtx);
		isProcessed.put(vtx, true);

		while (!stack.isEmpty()) {

			Vertex removed = stack.removeFirst();
			System.out.println(removed.vname);

			Set<Integer> neighbours = removed.neighbours.keySet();

			for (Integer neighbour : neighbours) {
				Vertex neigh = this.vertices.get(neighbour);

				if (!isProcessed.containsKey(neigh)) {

					stack.addFirst(neigh);
					isProcessed.put(neigh, true);
				}

			}

		}

	}

	public boolean detectCycleInDirectedGraph() {

		LinkedList<Vertex> stack = new LinkedList<>();
		HashMap<Vertex, Boolean> isProcessed = new HashMap<>();

		Vertex vtx = this.vertices.get(1);
		stack.addFirst(vtx);
		isProcessed.put(vtx, true);

		while (!stack.isEmpty()) {

			Vertex removed = stack.removeFirst();

			Set<Integer> neighbours = removed.neighbours.keySet();

			for (Integer neighbour : neighbours) {
				Vertex neigh = this.vertices.get(neighbour);

				if (!isProcessed.containsKey(neigh)) {

					stack.addFirst(neigh);
					isProcessed.put(neigh, true);
				} else {
					System.out.println(neigh.vname);
					return true;
				}

			}

		}

		return false;

	}

	public boolean detectCycleInUndirectedGraph() {

		Set<Integer> keys = this.vertices.keySet();

		for (Integer key : keys) {
			if (detectCycleInUndirectedGraphHelper(key, -1, new HashMap<>())) {
				return true;
			}
		}
		return false;

	}

	public boolean detectCycleInUndirectedGraphHelper(int vtxName, int vtxParent,
			HashMap<Integer, Boolean> isProcessed) {

		// mark as processed
		isProcessed.put(vtxName, true);

		// get neighbours
		Vertex vtx = this.vertices.get(vtxName);
		Set<Integer> neighbours = vtx.neighbours.keySet();

		for (Integer neighbour : neighbours) {

			// if neighbour is not processed then call for the neighbours
			if (!isProcessed.containsKey(neighbour)) {
				if (detectCycleInUndirectedGraphHelper(neighbour, vtxName, isProcessed)) {
					return true;
				}

				// if the processed neighbour is parent then its ok but if its not the parent
				// then its a loop element
			} else {
				if (neighbour != vtxParent) {
					return true;
				}

			}
		}
		return false;

	}

}
