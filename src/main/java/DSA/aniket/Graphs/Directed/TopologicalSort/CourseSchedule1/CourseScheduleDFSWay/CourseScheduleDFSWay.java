package DSA.aniket.Graphs.Directed.TopologicalSort.CourseSchedule1.CourseScheduleDFSWay;

import DSA.aniket.Graphs.Directed.TopologicalSort.CourseSchedule1.CourseSchedule1;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleDFSWay implements CourseSchedule1 {


    @Override
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
         * will be solve it using Detect a cycle in Directed Graph using DFS
         */
        int[] visit = new int[numCourses];
        int[] pathVisit = new int[numCourses];
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; i++) adj[i] = new ArrayList<>();
        buildAdj(prerequisites, adj);

        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                pathVisit[i] = 1;
                boolean isCyclic = detectCycle(i, visit, adj, pathVisit);
                pathVisit[i] = 0;
                if (isCyclic) return false;
            }
        }


        return true;
    }

    public boolean detectCycle(int node, int[] visit, List<Integer>[] adj, int[] pathVisit) {
        for (int neighbour : adj[node]) {
            if (pathVisit[neighbour] == 1) return true;
            pathVisit[neighbour] = 1;
            visit[neighbour] = 1;
            boolean isCyclic = detectCycle(neighbour, visit, adj, pathVisit);
            if (isCyclic) return true;
            pathVisit[neighbour] = 0;
        }

        return false;
    }

    public void buildAdj(int[][] pre, List<Integer>[] adj) {
        for (int[] edge : pre) {
            List<Integer> nodeList = adj[edge[0]];
            nodeList.add(edge[1]);
        }
    }
}