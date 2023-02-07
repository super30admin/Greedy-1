// Time Complexity :T: O(n)
// Space Complexity :: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
We can solve this problem with BFS and DFS with Memoization but it would take additional time and space complexity

We will try greedy approach , by checking from backwards

We will set the end index as the target, and will start checking from end - 1 index, to see if that index can reach the extends
and we will see if that would form a chain till the start, if till the start we are able to reach the end, then we would return true

T: O(n)
S: O(1);
*/
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int tIdx = nums.length-1;
        boolean result = false;
        for(int i=tIdx-1;i>=0;i--){
            int diff = tIdx- i;
            if(nums[i] >= diff){
                result = true;
                tIdx = i;
            }
            else{
                result = false;
            }
        }

        return result;
        
    }
}
