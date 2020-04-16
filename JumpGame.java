Time Complexity = O(n)
Space Complexity = O(1)


class Solution {
        public boolean canJump(int[] nums) {
            if(nums == null || nums.length < 2){
                return true;
            }
            int target = nums.length - 1;
            
            for(int i = target -1; i>=0;i--){
                if(i + nums[i] >= target){
                    target = i;
                }
            }
            return target == 0;
        }
}