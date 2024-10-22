package Greedy-1;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.
public class Problem2 {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n ==1) return 0;
        int jump = 1;
        int curInt = nums[0];
        int nextInt = nums[0];
        for(int i = 1; i < n; i++){
            nextInt = Math.max(nextInt, i + nums[i]);
            if(i == curInt){
                curInt = nextInt;
                if(i != n -1){
                    jump++;
                }
                
            }

        }
        return jump;
    }
}
