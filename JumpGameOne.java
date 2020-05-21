//Time complexity: O(n)
//Space Complexity: O(1)

public class JumpGameOne {
	public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        int destination = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= destination){
                destination = i;
            }
        }
        return destination == 0;
    }
}
