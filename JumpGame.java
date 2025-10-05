// This solution uses a greedy approach to get to the first index from the target
// We set the target initially to the last element. We iteratively decrement the tracking index i
// At every index if the index plus the value is greater than or equal to target that means the tracking index is valid enough to be converted into target
// At last if the target reaches 0 that is an indication that there is a path
class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length-1;

        int i=nums.length-2;
        while(i>=0) {

            if(i+nums[i]>=target) {
                target=i;
            }
            i--;
        }

        if(target==0) return true;
        return false;
    }
}
