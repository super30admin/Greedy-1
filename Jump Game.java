// Time Complexity : O(n)
// Space Complexity : O(1)
// Method used : Greedy

class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        
        int i = n - 2, index = n - 1;

        while(i >= 0)
        {
            if(nums[i] >= index - i) index = i;

            i--;
        }

        return index == 0 ? true : false;
    }
}