package DSA.aniket.Greedy.LemonadeChange.Solution;

import DSA.aniket.Greedy.LemonadeChange.LemonadeChange;

public class Solution implements LemonadeChange {

    /**
     * @param bills
     * @return
     */
    @Override
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int deno : bills) {
            if (deno == 5) five++;
            else if (deno == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else return false;
            } else {
                if (ten >= 1 && five >= 1) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else return false;
            }
        }
        return true;
    }
}