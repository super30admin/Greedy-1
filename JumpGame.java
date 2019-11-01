//Time Complexity:O(N)
//Space Complexity: O(1)
//Iterate over the nums array from the last store the last element as last before iteration.
//If the sum of value at ith index and i is > last then update last to i value
//Return if last is 0 then true else false
class Solution {
    public boolean canJump(int[] nums) {
        int last = nums.length-1;
        for(int i = nums.length-1; i>=0; i--)
        {
            if(i+nums[i] >= last)
            {
                last = i;
            }
        }
        return last == 0;
    }
}