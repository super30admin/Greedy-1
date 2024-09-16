package greedy1;

public class JumpGame {
// nums[] = {2,3,1,1,4}
	public static boolean canJump(int[] nums) {
        int lastpos = nums.length - 1;
        
        for(int i = nums.length - 1; i >= 0; i--) {
        	//if I am at number 3 (index = 1), I can take max 3 steps and reach {i + nums[i]} --> 1 + 3 = 4th index.  
            if(i + nums[i] >= lastpos) 
                lastpos = i;
        }
        return lastpos==0;
    }
	
	public static void main(String[] args ) {
		int[] nums = {2, 3, 1, 1, 4};
		System.out.println(canJump(nums)); // true
		
		int[] nums1 = {2, 2, 1, 0, 4};
		System.out.println(canJump(nums1)); // false
	}
}
