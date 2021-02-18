// time - O(N), Space -O(1)
class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length, farthest_index = 0 ;
        for(int i=0; i<n; i++) {
            if(farthest_index < i) return false;
            farthest_index = Math.max (i + nums[i] , farthest_index) ;
        }
        return true;
    }
}
