package k21;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub	
		Queue<Node> queue = new LinkedList<>();
		Set<Node> visited = new HashSet<>();
		
		queue.add(root);
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			if(current.getLabel().equals(goal)) {
				return current;
			}
			visited.add(current);
			for (Edge edge : current.getChildren()) {
				Node adjacent = edge.getEnd();
				if (!visited.contains(adjacent)) {
                    queue.add(adjacent);
                }
			}
		}
		return null;
	}

	@Override
	 public Node execute(Node root, String start, String goal) {
        Node startNode = findNode(root, start);

        if (startNode == null) {
            return null; // Start node not found
        }

        return execute(startNode, goal);
    }

    private Node findNode(Node root, String data) {
        if (root == null) {
            return null;
        }

        if (root.getLabel().equals(data)) {
            return root;
        }

        for (Edge edge : root.getChildren()) {
            Node adjacent = edge.getEnd();
            Node result = findNode(adjacent, data);
            if (result != null) {
                return result;
            }
        }

        return null;
    }
}
