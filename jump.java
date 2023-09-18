// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * This approach is similar to bfs where we process the numbers level wise, and find the max index we can reach from each level.
 * Once a level is processed we will increment the count.
 */

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0, farthest = 0;
        int count = 0;

        while(right < n){
            if(farthest == n-1)
                break;
                
            for(int i=left; i<=right; i++){
                farthest = Math.max(farthest, nums[i] + i);
            }
            left = right+1;
            right = farthest;
            count++;
        }

        return count;
    }
}
