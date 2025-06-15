package LeetCode.src.main.java.graph;

import java.util.*;
public class CourseScheduleDFS {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] pair: prerequisites){
            int course = pair[0];
            int prerequisite = pair[1];
            graph.get(prerequisite).add(course);
        }

        int[] visited = new int[numCourses];

        for (int i=0; i< numCourses;i++){
            if(!dfs(i,graph,visited)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, Map<Integer, List<Integer>> graph, int[] visited){
        if(visited[node]==1)  // 1 -> visiting
            return false;

        if(visited[node]==2) // 2 -> fully visited
            return true;

        visited[node]=1;

        for (int neighbor: graph.get(node)){
            if (!dfs(neighbor, graph, visited))
                return false;
        }

        visited[node] = 2;
        return true;
    }
    public static void main(String[] args) {
        CourseScheduleDFS sch = new CourseScheduleDFS();

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Test 2: " + sch.canFinish(numCourses2, prerequisites2)); // false

        int numCourses3 = 4;
        int[][] prerequisites3 = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println("Test 3: " + sch.canFinish(numCourses3, prerequisites3)); // true

    }
}
