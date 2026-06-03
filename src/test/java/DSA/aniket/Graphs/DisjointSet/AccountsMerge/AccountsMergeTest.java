package DSA.aniket.Graphs.DisjointSet.AccountsMerge;

import DSA.aniket.Graphs.DisjointSet.AccountsMerge.Solution.Solution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class AccountsMergeTest {

    private final AccountsMerge solution = new Solution();


    @Test
    @DisplayName("Example 1 - Standard LeetCode Example")
    @Timeout(1)
    void testExample1() {

        List<List<String>> accounts = List.of(
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("Mary", "mary@mail.com"),
                List.of("John", "johnnybravo@mail.com")
        );

        List<List<String>> result = solution.accountsMerge(accounts);

        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("Example 2 - Shared Email Merge")
    @Timeout(1)
    void testExample2() {

        List<List<String>> accounts = List.of(
                List.of("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"),
                List.of("Kevin", "Kevin3@m.co", "Kevin5@m.co"),
                List.of("Gabe", "Gabe3@m.co", "Gabe2@m.co")
        );

        List<List<String>> result = solution.accountsMerge(accounts);

        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("No Accounts Need Merging")
    @Timeout(1)
    void testNoMerge() {

        List<List<String>> accounts = List.of(
                List.of("Alex", "a@mail.com"),
                List.of("Alex", "b@mail.com")
        );

        List<List<String>> result = solution.accountsMerge(accounts);

        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Single Account")
    @Timeout(1)
    void testSingleAccount() {

        List<List<String>> accounts = List.of(
                List.of("John", "john@mail.com")
        );

        List<List<String>> result = solution.accountsMerge(accounts);

        List<List<String>> expected = List.of(
                List.of("John", "john@mail.com")
        );

        assertIterableEquals(expected, result);
    }

    @Test
    @DisplayName("All Accounts Merge Into One")
    @Timeout(1)
    void testAllMergeIntoOne() {

        List<List<String>> accounts = List.of(
                List.of("John", "a@mail.com", "b@mail.com"),
                List.of("John", "b@mail.com", "c@mail.com"),
                List.of("John", "c@mail.com", "d@mail.com")
        );

        List<List<String>> result = solution.accountsMerge(accounts);

        assertEquals(1, result.size());
        assertEquals(5, result.get(0).size());
    }

    @Test
    @DisplayName("Chain Merge Through Intermediate Account")
    @Timeout(1)
    void testChainMerge() {

        List<List<String>> accounts = List.of(
                List.of("A", "a@mail.com", "b@mail.com"),
                List.of("A", "b@mail.com", "c@mail.com"),
                List.of("A", "c@mail.com", "d@mail.com")
        );

        List<List<String>> result = solution.accountsMerge(accounts);

        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Different Names Sharing Email")
    @Timeout(1)
    void testSharedEmailDifferentNames() {

        List<List<String>> accounts = List.of(
                List.of("John", "x@mail.com"),
                List.of("Mary", "x@mail.com")
        );

        List<List<String>> result = solution.accountsMerge(accounts);

        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Multiple Independent Groups")
    @Timeout(1)
    void testMultipleGroups() {

        List<List<String>> accounts = List.of(
                List.of("A", "a1@mail.com"),
                List.of("A", "a2@mail.com"),
                List.of("B", "b1@mail.com"),
                List.of("B", "b2@mail.com")
        );

        List<List<String>> result = solution.accountsMerge(accounts);

        assertEquals(4, result.size());
    }

    @Test
    @DisplayName("Account With Many Emails")
    @Timeout(1)
    void testManyEmails() {

        List<List<String>> accounts = List.of(
                List.of(
                        "John",
                        "a@mail.com",
                        "b@mail.com",
                        "c@mail.com",
                        "d@mail.com",
                        "e@mail.com"
                )
        );

        List<List<String>> result = solution.accountsMerge(accounts);

        assertEquals(1, result.size());
        assertEquals(6, result.get(0).size());
    }

    @Test
    @DisplayName("Emails Should Be Sorted")
    @Timeout(1)
    void testSortedEmails() {

        List<List<String>> accounts = List.of(
                List.of("John", "z@mail.com", "a@mail.com", "m@mail.com")
        );

        List<List<String>> result = solution.accountsMerge(accounts);

        List<String> emails = result.get(0);

        assertEquals("a@mail.com", emails.get(1));
        assertEquals("m@mail.com", emails.get(2));
        assertEquals("z@mail.com", emails.get(3));
    }
}