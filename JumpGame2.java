// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : maintain currInt and max next interval from currInterval and number of jumps. Initiallys jumps=1, currInt
/// and nextInt = 1st element. for all elements in currInt, update nextInt to be max possible jump. If we reach currInt, update it to nextInt and increment jumps
/// If we reach currInt == end of array return jumps
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n<=1){
            return 0;
        }
        int jumps = 1;
        int currInt = nums[0], nxtInt = nums[0];
        for(int i = 1;i<n-1;i++){
            nxtInt = Math.max(nxtInt, i+nums[i]);
            System.out.println((i-1)+" "+currInt+" "+nxtInt);
            if(currInt == n-1){
                return jumps;
            }
            if(currInt == i){
                currInt = nxtInt;
                jumps++;
            }
        }
        return jumps;
    }
}