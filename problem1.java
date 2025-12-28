// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Appraoch
we are starting from back, of the list, basaically we are trying to see if
we can get to the end of the nums backward, if we can rech  n-2 from n-4 then
next check if n-4 can be reached becuase if we reach n-4 we know we can reach end, do this until to
until we have reached the begining of the array so num[0], at that point is target is also 0
basically we are looking to 0 and we start from 0 that means we can reach the top
*/
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target = n - 1;
        for (int j = n - 2; j >= 0; j--) {
            if (j + nums[j] >= target) {
                target = j;
            }
        }
        return target == 0;
    }
}