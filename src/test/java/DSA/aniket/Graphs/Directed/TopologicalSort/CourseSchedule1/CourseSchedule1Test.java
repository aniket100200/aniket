package DSA.aniket.Graphs.Directed.TopologicalSort.CourseSchedule1;

import DSA.aniket.Graphs.Directed.TopologicalSort.CourseSchedule1.Solution.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseScheduleTest {


    private final CourseSchedule1 solution = new Solution();

    // --- Tests ---

    @Test
    public void testExample1_CanFinish() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}}; // 0 -> 1

        assertTrue(solution.canFinish(numCourses, prerequisites), "Failed on Example 1: Linear prerequisite.");
    }

    @Test
    public void testExample2_CannotFinish_Cycle() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}}; // 0 -> 1 and 1 -> 0

        assertFalse(solution.canFinish(numCourses, prerequisites), "Failed on Example 2: Simple cycle should return false.");
    }

    @Test
    public void testNoPrerequisites() {
        int numCourses = 5;
        int[][] prerequisites = {};

        assertTrue(solution.canFinish(numCourses, prerequisites), "Failed when there are no prerequisites.");
    }

    @Test
    public void testComplexGraph_CanFinish() {
        int numCourses = 6;
        // 5->0, 5->2, 4->0, 4->1, 2->3, 3->1
        int[][] prerequisites = {
                {0, 5}, {2, 5}, {0, 4}, {1, 4}, {3, 2}, {1, 3}
        };

        assertTrue(solution.canFinish(numCourses, prerequisites), "Failed on a complex valid DAG.");
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

        assertFalse(solution.canFinish(numCourses, prerequisites), "Failed on a disconnected graph containing a cycle.");
    }

    @Test
    public void testLongChainPrerequisites() {
        int numCourses = 4;
        // 0 -> 1 -> 2 -> 3
        int[][] prerequisites = {
                {1, 0}, {2, 1}, {3, 2}
        };

        assertTrue(solution.canFinish(numCourses, prerequisites), "Failed on a long linear chain of prerequisites.");
    }
}