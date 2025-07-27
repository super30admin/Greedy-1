// Time complexity -O(n)
// space complexity - O(1)
// solved on leetcod e- yes
// faced any issues - No
// the target element will be last element initially, then updated target whether we can reach there or not
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int targetIndex = n-1;
        for(int i=n-2;i>=0;i--) {
            if(i+nums[i] >= targetIndex) {
                targetIndex = i;
            }
        }
        if(targetIndex == 0) return true;
        else return false;
    }
}
