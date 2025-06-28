package LeetCode.src.main.java.graph;

import java.util.*;

public class CourseScheduleDFS {

    public boolean canFinish(int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> courseSet = new HashSet<>();

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];

            graph.computeIfAbsent(prerequisite, k -> new ArrayList<>()).add(course);
            courseSet.add(course);
            courseSet.add(prerequisite);
        }

        Map<Integer, Integer> visited = new HashMap<>();

        for (int course : courseSet) {
            if (hasCycle(course, graph, visited)) {
                return false; // cycle found
            }
        }
        return true;
    }

    private boolean hasCycle(int course, Map<Integer, List<Integer>> graph, Map<Integer, Integer> visited) {
        if (visited.getOrDefault(course, 0) == 1)
            return true; // cycle
        if (visited.getOrDefault(course, 0) == 2)
            return false; // already processed

        visited.put(course, 1); // mark as visiting

        for (int neighbor : graph.getOrDefault(course, new ArrayList<>())) {
            if (hasCycle(neighbor, graph, visited)) return true;
        }

        visited.put(course, 2); // mark as visited
        return false;
    }

    public static void main(String[] args) {
        CourseScheduleDFS sch = new CourseScheduleDFS();

        int[][] prerequisites = {{1, 0}, {1,5},{0, 2},{6,0}, {2, 4}, {4, 5}, {3, 2}, {5, 3}};
        System.out.println("\nCan finish: " + sch.canFinish(prerequisites));
    }
}
