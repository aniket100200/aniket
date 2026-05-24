package DSA.aniket.Graphs.Directed.TopologicalSort.CourseScheduleII.solutions.CSIIBFS;

import DSA.aniket.Graphs.Directed.TopologicalSort.CourseScheduleII.CourseScheduleII;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class CSIIBFS implements CourseScheduleII {

    @Override
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = getGraph(numCourses, prerequisites, false);
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
        }
        int[] ans = new int[numCourses];
        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) que.add(i);

        }
        int index = 0;
        while (que.size() > 0) {
            int node = que.remove();
            ans[index++] = node;
            for (int neighbour : adj[node]) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) que.add(neighbour);
            }
        }

        if (index == numCourses) {
            return ans;
        }
        return new int[0];
    }


}