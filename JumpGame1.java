// Time Complexity : O(n) where n is the number of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was intially thinking to reach source to destination not the reverse
/* Your code here along with comments explaining your approach: Start from the destination. Move backwards, till the index plus the number is greater
than or equal to destination coordinates you can reach the destination. Once the condition satisfies, destination is updated to the previous
destination that can be reached. Similarly, the destination if it reaches the source, it means the path is possible.
*/
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){return true;}
        int destination = nums.length-1;
        int i;
        for(i = destination; i >= 0; i--){                                          // Start from the destination
            if(i + nums[i] >= destination){                                         // if index plus number > destination implies path exists
                destination = i;                                                    // Update the destination
            }
        }
        return destination == 0;                                                    // Has the destination reached the source
    }
}