package DSA.aniket.BinarySearch.onAnswers.AllocateMinimumPages;

import DSA.aniket.BinarySearch.onAnswers.AllocateMinimumPages.OptimalSolution.OptimalSolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Allocate Minimum Pages - Binary Search on Answer")
class BookAllocationTest {

    // Assuming signature: int findPages(int[] arr, int k)
//    AllocateMinimumPages solver = new LinearApproach();
    AllocateMinimumPages solver = new OptimalSolution();

    @Test
    @DisplayName("1. Standard Case: Example 1")
    void testExample1() {
        int[] arr = {12, 34, 67, 90};
        assertEquals(113, solver.findPages(arr, 2),
                "Should find the optimal contiguous split minimizing the maximum pages.");
    }

    @Test
    @DisplayName("2. Impossible Case: Example 2 (Students > Books)")
    void testStudentsGreaterThanBooks() {
        int[] arr = {15, 17, 20};
        assertEquals(-1, solver.findPages(arr, 5),
                "Must return -1 when it is impossible to give every student at least one book.");
    }

    @Test
    @DisplayName("3. Boundary: Only 1 Student")
    void testOneStudent() {
        int[] arr = {10, 20, 30, 40};
        // One student must take ALL the books. The answer is the sum of the array.
        assertEquals(100, solver.findPages(arr, 1),
                "If k=1, the answer is exactly the sum of all pages.");
    }

    @Test
    @DisplayName("4. Boundary: Students exactly equal to Books")
    void testStudentsEqualBooks() {
        int[] arr = {10, 20, 30, 40};
        // 4 books, 4 students. Each gets exactly 1 book.
        // The student with the biggest book dictates the maximum.
        assertEquals(40, solver.findPages(arr, 4),
                "If k == arr.length, the answer is the maximum element in the array.");
    }

    @Test
    @DisplayName("5. TRAP: The 'Do Not Sort' Constraint")
    void testOrderMatters() {
        int[] arr = {10, 20, 10, 30};
        int k = 2;
        // If the code accidentally sorts this to [10, 10, 20, 30], it would split as [10, 10] and [20, 30] -> max 50.
        // But in original order, optimal split is [10, 20, 10] (40) and [30] (30) -> max 40.
        assertEquals(40, solver.findPages(arr, k),
                "Algorithm must respect the original array order. Sorting will cause failures.");
    }

    @Test
    @DisplayName("6. High Volume / Max Sum Test")
    void testLargeSum() {
        // Constraints state arr.length up to 1,000,000 and arr[i] up to 1000.
        // The maximum possible sum is 1,000,000,000 (which safely fits in a 32-bit int,
        // but checking efficiency of the binary search is important).
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1000;
        }
        // 100,000 books, 1 student
        assertEquals(100000000, solver.findPages(arr, 1),
                "Must efficiently calculate massive totals without timing out.");
    }

    @Test
    @DisplayName("7. All Books are the Same Size")
    void testEqualSizeBooks() {
        int[] arr = {10, 10, 10, 10, 10, 10};
        assertEquals(30, solver.findPages(arr, 2),
                "Should divide uniform arrays evenly.");
    }
}