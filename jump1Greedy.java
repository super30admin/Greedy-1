//TC: O(n)
//Sc: O(1)
/**
 * start from last index. from there check current index + current value could
 * cross last index. if so update last position to reach to current index. reeat
 * till 0th index and at last check if the last position is updated to 0th
 * index.
 *
 */
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length < 2) return true;
        int target = nums.length-1;
        int n = nums.length;
        for(int i=n-2;i>=0;i--){
            if(i + nums[i] >= target){
                target = i;
            }
        }
        return target == 0;
    }
}
