// Time Complexity : O(n) where n is the number of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Selecting the interval with max jump as window size
/* Your code here along with comments explaining your approach: Start from current and next as the first element. Update the next element as the number
in the curr index so that window size is equal to the max jumps. If the index is equal to current, update current to the next.You just made a jump.
Update the next again from the new current and again select the window size as max jump till i reaches destination.
*/
class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){return 0;}
        int curr = nums[0], max = 0, start = 0, next = nums[0], jump = 1, i =0;
        while(i < nums.length-1){       
            next = Math.max(next, i + nums[i]);                                                     // Update the next to the max jump number
            if(i == curr)                                                                   // As you explore all the possible jumps
            {   
                curr = next;                                                                // Update the current to the next to get new window size
                jump++;                                                                             // you just made a jump
  
            }
            i++;
        }
        return jump;
    }
}