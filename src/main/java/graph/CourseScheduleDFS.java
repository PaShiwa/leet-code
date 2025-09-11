package LeetCode.src.main.java.graph;

import java.util.*;

public class CourseScheduleDFS {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); // edge pre[1] -> pre[0]
        }

        // 0 = unvisited, 1 = visiting, 2 = visited
        int[] state = new int[numCourses];

        // Run DFS on all nodes
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!dfs(i, graph, state)) {
                    return false; // cycle detected
                }
            }
        }
        return true; // no cycle → can finish
    }

    private boolean dfs(int course, List<List<Integer>> graph, int[] state) {
        // If currently visiting → cycle
        if (state[course] == 1) return false;
        // If already visited → safe
        if (state[course] == 2) return true;

        // Mark as visiting
        state[course] = 1;

        // Visit all neighbors (next courses)
        for (int next : graph.get(course)) {
            if (!dfs(next, graph, state)) {
                return false;
            }
        }

        // Mark as fully visited
        state[course] = 2;
        return true;
    }

    // Test
    public static void main(String[] args) {
        CourseScheduleDFS cs = new CourseScheduleDFS();

        int[][] prerequisites1 = {{1, 0},{0,2,},{3,1},{3,5},{2,4},{6,1},{4,6}};
        System.out.println(cs.canFinish(7, prerequisites1));
    }
}

