/* Time Complexity : O(n) 
 *  n - length of input array - nums */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Greedy

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int jumps = 1;
        int currInt = nums[0];
        int nextInt = nums[0];
        for(int i = 0; i < n; i++){
            nextInt = Math.max(nextInt, i + nums[i]);
            if(i == currInt && i != n-1){
                jumps++;
                currInt = nextInt;
            }
        }
        return jumps;
    }
}