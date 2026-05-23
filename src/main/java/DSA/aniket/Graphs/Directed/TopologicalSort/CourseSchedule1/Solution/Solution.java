package DSA.aniket.Graphs.Directed.TopologicalSort.CourseSchedule1.Solution;

import DSA.aniket.Graphs.Directed.TopologicalSort.CourseSchedule1.CourseSchedule1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution implements CourseSchedule1 {

    @Override
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
         * let's solve it using kahan's algorithm
         */
        //let's build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        buildAdjacencyList(prerequisites, adj);


        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][1]]++;
        }
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) que.add(i);
        int count = 0;
        while (que.size() > 0) {
            int node = que.remove();
            count++;
            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) que.add(neighbour);
            }

        }


        return count == numCourses;
    }

    public void buildAdjacencyList(int[][] pre, List<List<Integer>> adj) {
        for (int[] edge : pre) {
            adj.get(edge[0]).add(edge[1]);
        }
    }
}