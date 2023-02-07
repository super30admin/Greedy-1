// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach



/*
The question states that jump is always possible and we need to count the number of steps/jumps, not the numbers taken to get to the last index
We will start from the start
we will take maximum jump from start and then we would record the interval

We will see if between the interval we can jump even further, if so ,we will record it as the next interval
we will increment the jump as soon as our current interval finsihes,
at the end we would return the jump

*/
class Solution {
    public int jump(int[] nums) {

        // base case, when nums length is less than 2
        if(nums.length ==1) return 0;
        int curr =0,next =0;
        int jump = 0;
        curr = nums[0];
        next = curr;
        //if the first element can jump , then we only need one jump
        if(curr >=nums.length-1){
            return 1;
        }

        for(int i=1;i<nums.length-1;i++){
            int reach = nums[i] + i; // checking how much jump we can take from the current index
            // checking if this reach is better than any element in the interval, if so , then make the next interval this
            next = Math.max(next, reach);
            if(i == curr) {
                jump++; // as soon as the current interval is passed, we will increment the jump
                curr = next;
            }
        }

        if(next >= nums.length - 1) jump++; // if the element gave any interval greater or equal to the length, we will increment it

        return jump;
        
    }
}