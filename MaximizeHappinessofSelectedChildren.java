/* You are given an array happiness of length n, and a positive integer k.
There are n children standing in a queue, where the ith child has happiness value happiness[i]. You want to select k children from these n children in k turns.
In each turn, when you select a child, the happiness value of all the children that have not been selected till now decreases by 1. 
Note that the happiness value cannot become negative and gets decremented only if it is positive.
Return the maximum sum of the happiness values of the selected children you can achieve by selecting k children. */

import java.util.Arrays;
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length - 1;
        long sum = 0;
        int turn = 0;
        for(int i=n;i>=0;i--){
            sum = sum + Math.max(happiness[i] - turn, 0);
            turn++;
            if(turn >= k){
                break;
            }
            }
        return sum;
    }
}
        
