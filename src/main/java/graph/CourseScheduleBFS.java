package LeetCode.src.main.java.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleBFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0; i< numCourses; i++){
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for(int[] pre: prerequisites){
           int course = pre[0];
           int prerequisite = pre[1];

           graph.get(prerequisite).add(course);
           inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        int courseTaken = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            courseTaken++;

            for(int neighbor: graph.get(course)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
        }
        return numCourses==courseTaken;
    }

    public static void main(String[] args) {
        int numCourses =3;
        int [][] prerequisites = {{1,0},{0,1},{2,1}};
        System.out.println( new CourseScheduleBFS().canFinish(numCourses, prerequisites));
    }
}
