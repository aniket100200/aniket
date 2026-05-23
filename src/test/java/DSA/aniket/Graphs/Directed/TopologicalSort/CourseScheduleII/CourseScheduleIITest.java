package DSA.aniket.Graphs.Directed.TopologicalSort.CourseScheduleII;

import DSA.aniket.Graphs.Directed.TopologicalSort.CourseScheduleII.solutions.CSIIBFS.CSIIBFS;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseScheduleIITest {


    private final CourseScheduleII solution = new CSIIBFS();

    // --- Validation Helper ---

    // Validates if the returned array is a valid course order
    private boolean isValidCourseOrder(int numCourses, int[][] prerequisites, int[] result) {
        if (result == null || result.length != numCourses) return false;

        // Store the index of each course in the completion order
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            positionMap.put(result[i], i);
        }

        // For every prerequisite pair [course, prerequisite],
        // the prerequisite MUST appear before the course
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            // If prerequisite is taken AFTER the course, it's invalid!
            if (positionMap.get(prerequisite) > positionMap.get(course)) {
                return false;
            }
        }
        return true;
    }

    // --- Tests ---

    @Test
    public void testExample1_Linear() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}}; // 0 -> 1

        int[] result = solution.findOrder(numCourses, prerequisites);
        assertTrue(isValidCourseOrder(numCourses, prerequisites, result), "Failed on Example 1: Simple linear prerequisite.");
    }

    @Test
    public void testExample2_MultipleValidOrders() {
        int numCourses = 4;
        // 0 -> 1, 0 -> 2, 1 -> 3, 2 -> 3
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        int[] result = solution.findOrder(numCourses, prerequisites);
        assertTrue(isValidCourseOrder(numCourses, prerequisites, result), "Failed on Example 2: Complex valid DAG.");
    }

    @Test
    public void testExample3_Cycle_ReturnsEmptyArray() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}}; // 0 -> 1 and 1 -> 0

        int[] result = solution.findOrder(numCourses, prerequisites);
        assertEquals(0, result.length, "Failed on Example 3: Cycle should result in an empty array.");
    }

    @Test
    public void testNoPrerequisites() {
        int numCourses = 5;
        int[][] prerequisites = {};

        int[] result = solution.findOrder(numCourses, prerequisites);
        assertTrue(isValidCourseOrder(numCourses, prerequisites, result), "Failed when there are no prerequisites.");
    }

    @Test
    public void testDisconnectedGraph_WithCycle() {
        int numCourses = 5;
        // Component 1: 1 -> 0 (Valid)
        // Component 2: 2 -> 3 -> 4 -> 2 (Cycle!)
        int[][] prerequisites = {
                {0, 1},
                {3, 2}, {4, 3}, {2, 4}
        };

        int[] result = solution.findOrder(numCourses, prerequisites);
        assertEquals(0, result.length, "Failed on disconnected graph with a cycle. Should return an empty array.");
    }
}