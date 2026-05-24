package DSA.aniket.Graphs.Directed.TopologicalSort.CourseScheduleII;

import DSA.aniket.Graphs.Graph;

import java.util.ArrayList;
import java.util.List;

public interface CourseScheduleII extends Graph {
    int[] findOrder(int numCourses, int[][] prerequisites);


    default List<Integer>[] getGraph(int V, int[][] edges, boolean isUndirected) {
        List<Integer>[] ans = new List[V];
        for (int i = 0; i < V; i++) ans[i] = new ArrayList<>();

        for (int[] pre : edges) {
            /**
             * [a,b]
             * tif you wanted to do  course `a` you must complete  `b` first
             * there should be edge between b-->a
             */
            int a = pre[0], b = pre[1];
            ans[b].add(a);
        }

        return ans;
    }
}