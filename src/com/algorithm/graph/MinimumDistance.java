package com.algorithm.graph;

import java.util.HashMap;
import java.util.Scanner;

import com.util.Print;

public class MinimumDistance {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashMap<Object, Integer> keyMap = new HashMap<>();
		for (int i = 0; i < n; i++) { // Setting Hashmap. Indexing the Input type
			keyMap.put(sc.next(), i);
		}
		Integer graph[][] = new Integer[n][n];
		int edges = sc.nextInt();
		for (int i = 0; i < edges; i++) {
			Integer u = keyMap.get(sc.next());
			Integer v = keyMap.get(sc.next());
			Integer weight = sc.nextInt();
			if (null != u && null != v) {
				graph[u][v] = weight;
			}
		}
		Integer[][] minDistance = minDistance(graph, n); // Generating minimum distance array
		int query = sc.nextInt();
		while (query-- > 0) { // looping through the testcases/queries
			Integer u = keyMap.get(sc.next());
			Integer v = keyMap.get(sc.next());
			if (null != u && null != v) {
				Print.print(minDistance[u][v]);
			}
		}
		sc.close(); // Closing Scanner
	}

	private static Integer[][] minDistance(Integer[][] graph, int n) { // Method good for multiple (u,v) in case of
																		// single, dont use outer loop
		Integer[][] minDistance = new Integer[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				minDistance[i][j] = (graph[i][j] == null) ? (i == j) ? 0 : Integer.MAX_VALUE : graph[i][j];
			}
		}
		for (int k = 0; k < n; k++) {
			Boolean visited[] = new Boolean[n];
			for (int j = 0; j < visited.length; j++) {
				visited[j] = Boolean.FALSE;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i] && graph[j][i] != null && minDistance[k][j] != Integer.MAX_VALUE
							&& minDistance[k][i] > graph[j][i] + minDistance[k][j]) {
						minDistance[k][i] = graph[j][i] + minDistance[k][j];
						visited[i] = true;
					}
				}
			}
		}
		return minDistance;
	}

}
