// Time Complexity :O(n), where n is the size of the array
// Space Complexity :O(1), no extra space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner approach of your code in plain english
//1. We can do a bottom-up approach here (Intution -> to check if you can reach from a start to end, You check if you can reach end 
        //to start. That is start from your destination and check if you can reach there starting from its neighbouring index)
//2. Create a destination varibale and assign the last index(target) to it. Start traversing the array from the 2nd last index in a
        // reverse order And at each index check if you can reach the destination with the maximum jumps (i+nums[i] >= destination)
//3. If, yes that means you can for sure reach the current destination, So now if assign the current index to the destination And check
        //if you can reach this current destination AND so on.
//In the End check if the destination is 0 (you were able to reach the start);

// Your code here along with comments explaining your approach

class Solution {
    public boolean canJump(int[] nums) {
        //edge case
        if(nums.length == 1) return true;
        int n = nums.length;
        //variable to hold the current destination
        int destination = n-1; //bottom-up approach
        
        //itervate over the array in a reverse order and check if you can reach the current destination
        for(int i= n-2; i>=0; i--){
            //check if you can reach the destination from this index
            if(i+nums[i] >= destination){
                //make the current index as destination and chck if this destination can be reached
                destination = i;
            }
        }
        //in the end check if destination has become 0 (meaning you can reach start from the end)
        return destination==0;
    }
}