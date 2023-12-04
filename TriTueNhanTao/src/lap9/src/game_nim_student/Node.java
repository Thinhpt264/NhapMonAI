package game_nim_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		// Enter your code here
		List<Node> reee = new ArrayList<Node>();
		for (int i = 0 ; i < data.size(); i++ ) {
			int n = data.get(0);
			for(int t = 0; t< n/2 ; t++) {
				Node tmp = new Node();
				tmp.add(n-t);
				tmp.add(t);
				reee.add(tmp);
			}
			reee.remove(0);
		}
		return reee;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		// Enter your code here
		 boolean result = true;
		 Collections.sort(data, DESCOMPARATOR);
		 if(data.get(0) >2) {
			 result = false;
		 }
		 return result;
		 
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
