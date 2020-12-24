package Dec23;

class JumpGame {
	
    public boolean canJump(int[] nums) {
    
        /*
        Time complexity: O(n)
        
        Approach:
        
        Invert the nums array tree on its head so that we start checking backward from given destination to source.
        Check: current element index + current element value >= destination
        If yes, reset destination to one index before and current to one index before.
        If no, reset current to one index before. Don't move the destination.
        */
        
        //edge
        if (nums == null || nums.length < 2) {
            return true;
        }
        
        int n = nums.length;
        int dest = n -1;
        
        for (int i = n-2; i >= 0; i--) {
            if(nums[i] + i >= dest) {
                dest = i;
            }
        }
        
        if (dest == 0) {
            return true;
        }
        
        return false;   
    }
   
}
