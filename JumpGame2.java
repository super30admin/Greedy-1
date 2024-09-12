/**
 * Time Complexity : O(n) where n is the number of elements in the array
 * Space Complexity : O(1)
 */

public class JumpGame2 {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){return 0;}
        int curr = nums[0], next = nums[0], jump = 1, i =0;
        while(i < nums.length-1){       
            next = Math.max(next, i + nums[i]);                                                    
            if(i == curr)                                                                   
            {   
                curr = next;                                                                
                jump++;                                                                            
  
            }
            i++;
        }
        return jump;
    }
}