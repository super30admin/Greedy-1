//Time = O(n), iterating through array
//Space = O(1), constant space

class Solution {
    public int jump(int[] nums) {
        int jumps = 0; // variable to keep track of number of jumps
        int currEnd = 0; // variable to keep track of the farthest index that can be reached with the current number of jumps
        int currFarthest = 0; // variable to keep track of the farthest index that can be reached with the next jump
        
        for (int i = 0; i < nums.length - 1; i++) { // iterate through array up to second to last element
            currFarthest = Math.max(currFarthest, i + nums[i]); // update currFarthest if the next index can be reached with the next jump
            if (i == currEnd) { // if current index is equal to the current end of the range of indices that can be reached with current jumps
                jumps++; // increment number of jumps
                currEnd = currFarthest; // update current end of range to be the farthest index that can be reached with the next jump
            }
        }
        return jumps; // return number of jumps
    }
}
