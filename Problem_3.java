// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// take the next and current integer pointer, increase the next per the increase in path, and reset the curr with the next if i and curr become same.
// Your code here along with comments explaining your approach
class Solution {
    public int jump(int[] nums) {
        if( nums == null || nums.length < 2 ) return 0;
        int next = nums[0]; int curr = nums[0];
        int count = 1;
        for( int i = 1; i < nums.length-1; i++){
            next = Math.max(next, i+nums[i]);
            if( i == curr){
                curr = next;
                count++;
            }
        }
        return count;
    }
}