
// Time Complexity : O(n)
// Space Complexity : O(1)

//We start from the first index and keep track of the current maximum reachable interval.
//If we reach the end of the current maximum reachable interval, we increment the jump count
//and update the current maximum reachable interval to the overall maximum reachable interval.
//Finally, we return the jump count.

class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        if(n==1)
            return 0;
        int jumps=1,currInt=nums[0],maxInt=nums[0];

        for(int i=1;i<n;i++){
            maxInt=Math.max(maxInt,i+nums[i]);
            if(i!=n-1 && i==currInt){
                currInt=maxInt;
                jumps++;
            }
        }
        return jumps;
    }
}