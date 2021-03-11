//Time Complexity: o(n)
//Space Complexity; 0(1)
//Expln: Traverse the array from back by setting targets, Initially the target is last element and if we are able to reach
// target set that element as a next target and iterate through the array. At the end if the target is 0. Then we are able to reach
// to the end.
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len < 2) return true;
        int target = len -1;
        for(int i = len -2; i >=0; i--)
        {
            if(nums[i] + i >= target)
            {
                target = i;
            }
        }
        if(target == 0)
            return true;
        return false;
    }
}