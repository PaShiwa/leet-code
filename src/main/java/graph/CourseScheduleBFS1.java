package LeetCode.src.main.java.graph;

import java.util.*;
/*
   When course IDs don’t start from 0 and are non-contiguous like [57, 99, 22],
   you cannot use an array like int[] inDegree = new int[numCourses] because
   the indices won’t align with the course IDs.
*/
public class CourseScheduleBFS1 {

    public boolean canFinish(int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Set<Integer> courses = new HashSet<>();

        // build the graph
        for(int[] pair: prerequisites){
            int course = pair[1];
            int prerequisite = pair[0];

            graph.computeIfAbsent(prerequisite, k -> new ArrayList<>()).add(course);
            inDegree.put(course,inDegree.getOrDefault(course,0)+1);

            // register the courses in the set
            courses.add(course);
            courses.add(prerequisite);
        }

        // queue of the courses with no prerequisite : inDegree -> 0
        Queue<Integer> queue = new LinkedList<>();
        for(int course: courses){
            if(!inDegree.containsKey(course)){
                queue.offer(course);
            }
        }

        int coursesTaken = 0;

        // process courses
        while(!queue.isEmpty()){
            int current = queue.poll();
            coursesTaken++;

            for(int neighbor: graph.getOrDefault(current, new ArrayList<>())){
                inDegree.put(neighbor, inDegree.get(neighbor)-1);
                if(inDegree.get(neighbor)==0){
                    // add to the queue
                    queue.offer(neighbor);
                }
            }
        }
        return coursesTaken == courses.size();
    }

    public static void main(String[] args){
        CourseScheduleBFS1 cs = new CourseScheduleBFS1();
        int[][] prerequisites1 = {{0,1},{1,2}};
        int[][] prerequisites2 = {{99,57},{57,2},{2,99}};

        System.out.println(cs.canFinish(prerequisites1));
        System.out.println(cs.canFinish(prerequisites2));

    }
}
