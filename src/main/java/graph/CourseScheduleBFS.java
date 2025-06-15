package LeetCode.src.main.java.graph;

import java.util.*;
public class CourseScheduleBFS {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        // 1. Build the graph and the in-degree array

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for(int i =0; i< numCourses; i++){
            graph.put(i, new ArrayList<>());
        }

        for (int[] pair: prerequisites){
            int course = pair[0], prerequisite = pair[1];
            graph.get(prerequisite).add(course); // prerequisite -> course
            inDegree[course]++;
        }

        // 2. Initialize the queue with all in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i =0; i< numCourses; i++){
            if (inDegree[i]==0){
                queue.offer(i);
            }
        }

        int completedCourses = 0;
        // 3. Process the queue
        while(!queue.isEmpty()){
            int course = queue.poll();
            completedCourses++;

            for(int neighbor: graph.get(course)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
        }
        // 4. If all the courses are completed -> return true
        return completedCourses == numCourses;
    }

    public static void main(String[] args) {
        CourseScheduleBFS bfs = new CourseScheduleBFS();

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Test 2: " + bfs.canFinish(numCourses2, prerequisites2));

        int numCourses3 = 4;
        int[][] prerequisites3 = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println("Test 3: " + bfs.canFinish(numCourses3, prerequisites3));

    }
}
