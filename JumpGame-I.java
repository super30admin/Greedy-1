//time o(n)
//space o(1)
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2)
            return true;
        int len = nums.length;
        int destination = len-1;
        
        for(int i=len-2; i>=0; i--) {
            if((nums[i]+i) >= destination) {
                destination = i;
                if(i==0) {
                    return true;
                }
            }
        }
        return false;
    }
}