// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        int len = nums.length;
        int[] arr = new int[nums.length];
        for(int i=0;i<len;i++) {
            if( arr[i] > 0 || i == 0 ) {
                for(int j=1;j<=nums[i];j++) {
                    int count = arr[i] + 1;
                    int nextIndex = i + j;
                    if(nextIndex == len - 1) return true;
                    if(nextIndex < len) {
                        arr[nextIndex] = Math.max(arr[nextIndex], count);
                    }
                }
            }
        }
        return arr[len-1]>0 ? true : false;
    }
}
