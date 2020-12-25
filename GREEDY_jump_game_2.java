// Time Complexity :O(n), where n is the size of the array
// Space Complexity :O(1), no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner approach of your code in plain english
//Intuition -> In the current interval(intially the maximum jump you can take from 0th index) try to the find the best next interval
                //(where you want to take your next jump)
//1. maintian 3 variables (current interval(0th index value) , next interval(0th index value) and jumps(1)).
//2. Iterate over the array from 1 index and till index is less than OR equal to the current interval, try to find the maximum 
        //next interval (Math.max(nextInt, i+nums[i]))
//3. if the index goes beyond the current interval, increase jump by 1(you have decided to take jumop at the next interval (best
        //possible jump)) and reset your current interval to next interval (you find the next interval for this current interval)
//In the end return jumps (denoting minimum number of jumps)

// Your code here along with comments explaining your approach

class Solution {
    public int jump(int[] nums) {
        //edge case
        if(nums.length == 1) return 0;
        //variable to maintain current interval
        int currInt = nums[0];
        //variable to maintain next interval
        int nextInt = nums[0];
        //variable to maintain min number of jumps
        int jumps = 1;
        
        //iterate over the array
        for(int i=1; i<nums.length; i++){
            //if i is gone outside the current interval, meaning you are done exploring the biggest jump you can take. (which is calculated in next interval). So increase the jump by 1 and reset the current interval to next interval
            if(i > currInt){
                jumps++;
                currInt = nextInt;
            }
            //calculate the next interval
            nextInt = Math.max(nextInt, i+nums[i]);
        }
        return jumps;
    }
}