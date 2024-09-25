// Time C: O(n)
// Space C: O(1)
public class JumpGame {
        public boolean canJump(int[] nums) {
            return dfs(nums, 0);
        }
        private boolean dfs(int [] nums, int idx){
            // base
            if(idx >= nums.length - 1) {
                return true;
            }
            //logic
            for(int j = 1; j <= nums[idx]; j++){
                int newIdx = idx + j;
                if(dfs(nums, newIdx))return true;
            }
            return false;
        }
        
    }
    