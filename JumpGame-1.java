//time complexity is O(N)
//Space complexity is O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int len =nums[0];
        boolean result = true;
        for(int i=1;i<nums.length;i++){
            if(len<=0){
                return false;
            }
            len=Math.max(len-1, nums[i]);
        }
        return true;
    }
}