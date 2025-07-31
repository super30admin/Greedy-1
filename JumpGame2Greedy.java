// TC: O(N)
// SC: O(1)
class Solution {
    public int jump(int[] nums) {
        int jumps = 1;
        int n = nums.length;
        int currInvl = nums[0];
        int nextInvl = nums[0];
        if (n < 2)
            return 0;
        for (int i = 1; i < n; i++) {
            nextInvl = Math.max(nextInvl, i + nums[i]);
            if (currInvl == i) {
                currInvl = nextInvl;
                if(i != n-1){
                    jumps++;
                }
            }
        }
        return jumps;
    }
}