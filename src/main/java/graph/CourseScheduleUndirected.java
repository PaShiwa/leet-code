package LeetCode.src.main.java.graph;

import java.util.*;
public class CourseScheduleUndirected {


        // Function to check if the graph contains a cycle
        public boolean hasCycle(int n, int[][] edges) {
            // Step 1: Build adjacency list for the undirected graph
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>()); // initialize adjacency list for each node
            }

            // Step 2: Add edges (since undirected, add both directions)
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                graph.get(u).add(v); // add v to u’s list
                graph.get(v).add(u); // add u to v’s list
            }

            // Step 3: Keep track of visited nodes
            boolean[] visited = new boolean[n];

            // Step 4: Run DFS for each unvisited node (in case graph is disconnected)
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    // If DFS finds a cycle, return true immediately
                    if (dfs(i, -1, visited, graph)) {
                        return true;
                    }
                }
            }

            // If no cycle found in any component
            return false;
        }

        // DFS function to detect cycle
        private boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> graph) {
            visited[node] = true; // mark current node as visited

            // Explore all neighbors of the current node
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    // If neighbor not visited, continue DFS
                    if (dfs(neighbor, node, visited, graph)) {
                        return true; // cycle found in deeper recursion
                    }
                } else if (neighbor != parent) {
                    // If neighbor already visited and not parent,
                    // then we found a back edge (cycle exists)
                    return true;
                }
            }

            // If no cycle found from this node
            return false;
        }

        // Example usage
        public static void main(String[] args) {
            CourseScheduleUndirected graphChecker = new CourseScheduleUndirected();

            // Example graph with 4 nodes and edges
            int n = 4;
            int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {2, 3}};

            // Run cycle detection
            boolean hasCycle = graphChecker.hasCycle(n, edges);

            System.out.println("Graph contains cycle: " + hasCycle);
        }
    }

