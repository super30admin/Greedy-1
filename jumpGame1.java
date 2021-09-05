// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
import java.util.Set;

class jump1 {
    Set<Integer> visited;
    public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums == null)
            return false;
        
        if(nums.length == 1)
            return true;
        
        int n = nums.length;
        int dest = nums.length - 1;
        
        //iterate backwards
        for(int i = n - 2; i >= 0; i--){
            
            //add index and jumps, compare with destination
            //if we reach destination then new destination is index
            if(nums[i] + i >= dest){
                dest = i;
            }
        }
        //once we reach 0 we can return true
        return dest == 0;
    }
    
}