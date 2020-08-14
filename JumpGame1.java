/**
 * Time Complexity : O(n) where n is the number of elements in the array
 * Space Complexity : O(1)
 */
public class JumpGame1{
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){return true;}
        int destination = nums.length-1;
        int i;
        for(i = destination; i >= 0; i--){                                          
            if(i + nums[i] >= destination){                                       
                destination = i;                                                    
            }
        }
        return destination == 0;                                                    
    }
}