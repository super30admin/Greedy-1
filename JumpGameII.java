// Time Complexity: O(n)
// Space Complexity: O(1)

/*
 * traverse through the array and keep track of current and next interval.
 * we move the next interval to the max value we can reach and if
 * we reach the current interval increment jump and current.
 */

 class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int n = nums.length;
        int currInt = nums[0];
        int nextInt = nums[0];
        int jump = 1;

        for(int i = 0; i < n; i++){
            nextInt = Math.max(nextInt, i + nums[i]);
            if(i == currInt && i != n-1){
                jump++;
                currInt = nextInt;
            }
        }
        return jump;
    }
}