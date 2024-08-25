// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Calculated nextInterval after updating jump and currInterval which was causing issue for [1,1,1,1]

/*
Approach: Use 3 variables initilaized as jump = 1; currInterval = nums[0] & nextInterval = nums[0]. Then iterate over nums[] and calculate nextInterval by taking max of curr index + curr element & nextInterval. Then check if i == currInterval and is not the last element increment jump by 1 and currInterval = nextInterval. Finally return jump.
 */
class Solution {
    public int jump(int[] nums) {

        if(nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }

        int jump = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];

        for(int i = 0; i < nums.length; i++){

            nextInterval = Math.max(nextInterval, i + nums[i]);

            if(currInterval == i && i < nums.length - 1){
                currInterval = nextInterval;
                jump ++;
            }

        }

        return jump;
    }
}