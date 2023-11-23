package lab_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();
	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}
	public Node execute() {
		initPopulation(); // Initialize population
		Node bestSolution = null;
		for (int iteration = 0; iteration < MAX_ITERATIONS; iteration++) {
			List<Node> newPopulation = new ArrayList<>();
			for (int i = 0; i < POP_SIZE; i++) {
				Node parent1 = getParentByTournamentSelection();
				Node parent2 = getParentByRandomSelection();
				Node child = reproduce(parent1, parent2);
				if (rd.nextDouble() < MUTATION_RATE) {
					mutate(child);
				}
				newPopulation.add(child);
			}
			population = newPopulation;
		}
		Collections.sort(population);
		return population.get(0);
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		int queenIndex = rd.nextInt(node.N);
		int newRow = rd.nextInt(node.N);
		node.getState()[queenIndex].setRow(newRow);
	}
	// Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		int number = rd.nextInt(0, 8);
		Node node = new Node();
		if (number == 0) {
			node = y;
		} else if (number == 7) {
			node = x;

		} else {
			for (int i = 0; i < number; i++) {
				int rowX = x.getState()[i].getRow();
				node.getState()[i].setRow(rowX);
			}
			for (int i = 0; i < y.N; i++) {
				int rowY = y.getState()[i].getRow();
				node.getState()[i].setRow(rowY);
			}
		}
		return node;
	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
		List<Node> re = new ArrayList<Node>();
		int k = 3;
		Node bestNode = getParentByRandomSelection();
		for (int i = 0; i < k - 1; i++) {
			Node randomNode = getParentByRandomSelection();
			if (bestNode.getH() > randomNode.getH())
				bestNode = randomNode;
			{
			}
		}
		return bestNode;
	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() {
		int num = rd.nextInt(0, 100);
		Node node = population.get(num);
		return node;
	}
}
