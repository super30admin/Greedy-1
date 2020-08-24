// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach
// Start from current and next as first element. Update the next ele as the number in the 
// curr index so that window size is equal to the max jumps. If the index is equal to current,
// update current to next and increment the jump count. Update the next again from new curr and again select
// window size as max jump till i reaches destination.

class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0  || nums.length == 1) return 0;
        int curr = nums[0], next = nums[0], max = 0, jump = 1, i = 0;
        while(i <  nums.length-1) {
            next = Math.max(next,i+nums[i]);
            if(i == curr) {
                curr = next;
                jump++;
            }
            i++;
        }
        return jump;
    }
}