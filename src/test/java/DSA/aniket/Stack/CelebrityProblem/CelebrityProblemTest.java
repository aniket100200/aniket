package DSA.aniket.Stack.CelebrityProblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CelebrityProblemTest {
    Solution finder= new Solution();
    @Test
    void ifCelebrityPresent(){

        int[][]M=new int[][]{{0,1},{0,0}};
        int n=2;
        assertEquals(1, finder.findCelebrity(M,n));
    }

    @Test
    void ifCelebrityNotPresent(){
        //test case 2
       int[][] M=new int[][]{{0,1},{1,0}};
       int n=2;

        assertEquals(-1, finder.findCelebrity(M,n));
    }

    @Test
    void test1_CelebrityInMiddle() {
        // Person 1 is the celebrity
        int[][] M = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}
        };
        assertEquals(1, finder.findCelebrity(M, 3), "Person 1 should be the celebrity");
    }

    @Test
    void test2_CelebrityAtStart() {
        // Person 0 is the celebrity
        int[][] M = {
                {0, 0, 0},
                {1, 0, 0},
                {1, 1, 0}
        };
        assertEquals(0, finder.findCelebrity(M, 3), "Person 0 should be the celebrity");
    }

    @Test
    void test3_CelebrityAtEnd() {
        // Person 2 is the celebrity
        int[][] M = {
                {0, 0, 1},
                {0, 0, 1},
                {0, 0, 0}
        };
        assertEquals(2, finder.findCelebrity(M, 3), "Person 2 should be the celebrity");
    }

    @Test
    void test4_NoCelebrity_EveryoneKnowsEveryone() {
        // Everyone knows everyone, no one is a celebrity
        int[][] M = {
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        };
        assertEquals(-1, finder.findCelebrity(M, 3), "Should return -1 when everyone knows everyone");
    }

    @Test
    void test5_NoCelebrity_NoOneKnowsAnyone() {
        // No one knows anyone, so no one is famous enough to be a celebrity
        int[][] M = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        assertEquals(-1, finder.findCelebrity(M, 3), "Should return -1 when no one knows anyone");
    }

    @Test
    void test6_TwoPeople_PersonZeroIsCelebrity() {
        // Minimal valid matrix: 1 knows 0, 0 knows nobody
        int[][] M = {
                {0, 0},
                {1, 0}
        };
        assertEquals(0, finder.findCelebrity(M, 2), "Person 0 should be the celebrity in a 2-person group");
    }

    @Test
    void test7_TwoPeople_NoCelebrity() {
        // 0 and 1 know each other
        int[][] M = {
                {0, 1},
                {1, 0}
        };
        assertEquals(-1, finder.findCelebrity(M, 2), "Should return -1 if two people know each other");
    }

    @Test
    void test8_CandidateFailsCheck_KnowsSomeone() {
        // Person 1 is everyone's candidate (0 knows 1, 2 knows 1),
        // BUT Person 1 knows Person 2.
        int[][] M = {
                {0, 1, 0},
                {0, 0, 1},
                {0, 1, 0}
        };
        assertEquals(-1, finder.findCelebrity(M, 3), "Should return -1 if the potential celebrity knows someone");
    }

    @Test
    void test9_CandidateFailsCheck_NotKnownByEveryone() {
        // Person 1 knows nobody, 2 knows 1, BUT 0 does not know 1.
        int[][] M = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 1, 0}
        };
        assertEquals(-1, finder.findCelebrity(M, 3), "Should return -1 if someone doesn't know the potential celebrity");
    }

    @Test
    void test10_LargeGroup_SingleCelebrity() {
        // 5 people, Person 3 is the celebrity
        int[][] M = {
                {0, 1, 0, 1, 0},
                {0, 0, 1, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0}
        };
        assertEquals(3, finder.findCelebrity(M, 5), "Person 3 should be the celebrity in a larger matrix");
    }
}


