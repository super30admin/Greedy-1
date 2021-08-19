// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] arr = new int[nums.length];
        arr[0] = 0;
        for(int i=0;i<len;i++) {
            for(int j=1;j<=nums[i];j++) {
                int count = arr[i] + 1;
                int nextIndex = i + j;
                if(nextIndex < len) {
                    //This is used instead of array.fill so that when we do min operation it's not 0.
                    // Instead we can also put the array.fill on the top but thats less effecient
                    if(arr[nextIndex] == 0) arr[nextIndex] = Integer.MAX_VALUE/2;
                    arr[nextIndex] = Math.min(arr[nextIndex], count);
                }
            }
        }
        return arr[len-1];
    }
}
