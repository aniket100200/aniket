package DSA.aniket.BinarySearch.onAnswers.PaintersPartition.OptimalSolution;

import DSA.aniket.BinarySearch.onAnswers.PaintersPartition.PaintersPartition;

public class OptimalSolution implements PaintersPartition {

    @Override
    public int minTime(int[] boards, int painters) {
        if (boards.length < painters) return -1;//it is impossible to do that because each painter should get a work

        long low = 0, high = 0;

        for (int board : boards) {
            low = Math.max(low, board);
            high += board;
        }

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (isPossible(mid, boards, painters)) {
                low = mid + 1;
            } else high = mid - 1;
        }

        return (int) low;

    }


    public boolean isPossible(long maxBoardsToPaintAllowedPerPainter, int[] boards, int painters) {
        int paintersCount = 1;
        int boardsPaintedByCurrentPaintersTillNow = 0;

        for (int board : boards) {
            if (boardsPaintedByCurrentPaintersTillNow + board <= maxBoardsToPaintAllowedPerPainter) {
                boardsPaintedByCurrentPaintersTillNow += board;
            } else {
                paintersCount++;
                boardsPaintedByCurrentPaintersTillNow = board;
            }
        }

        return paintersCount > painters;
    }
}