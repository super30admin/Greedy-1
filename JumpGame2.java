// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//code 4 - greedy, starting at the begining we try to find the best way to reach the destination

class Solution {
    public int jump(int[] nums) {

        if(nums.length < 2)
            return 0; //no jumps required

        int jumps = 1; //we have to take a jump from the first index

        //interval = standing at an index, which all indices can be covered in jumps
        int currInterval = nums[0];
        int nextInterval = nums[0];

        //standing in the current interval we try to optimise the next interval

        for(int i=0; i<nums.length; i++) {
            //find the longest possible jump between previous max and the current index of the interval we are exploring
            nextInterval = Math.max(nextInterval, nums[i] + i);

            //i reaches end of current interval and it is not the last index
            if(i == currInterval && i != nums.length-1) {
                //increment number of jumps
                jumps++;
                //make nextInterval the new currInterval
                currInterval = nextInterval;
            }
        }
       return jumps;
    }
}
