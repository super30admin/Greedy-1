//Time -> O(n)
//Space -> O(1)

public class Problem1 {
        public boolean canJump(int[] nums) {
            int target = nums.length - 1;
            for(int i = nums.length - 2; i >= 0; i--){
                if(nums[i] + i >= target)
                    target = i;
            }
            return target == 0;
        }
        
}
