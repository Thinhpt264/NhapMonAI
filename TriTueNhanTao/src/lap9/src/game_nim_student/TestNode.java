package game_nim_student;

import java.util.Arrays;
import java.util.List;

public class TestNode {
	public static void main(String[] args) {
		Node node = new Node();
		Integer[] data = { 7,3,2,34,4,5 };
		node.addAll(Arrays.asList(data));

		MinimaxAlgo algo = new MinimaxAlgo();
		algo.execute(node);
	}
}