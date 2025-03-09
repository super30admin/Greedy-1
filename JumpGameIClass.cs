// TC => O(n)
// SC => O(n)

public class Solution {
    public bool CanJump(int[] nums) {
        if(nums == null || nums.Length == 0){
            return false;
        }

        int destination = nums.Length - 1;
        for(int i = nums.Length - 2; i >= 0; i--){
            if(i + nums[i] >= destination){
                destination = i;
            }
        }

        return destination == 0;
    }
}