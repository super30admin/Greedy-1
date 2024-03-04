// Time Complexity : O(n)
// Space Complexity : O(1)
// Method used : Greedy

class Solution {
    public int jump(int[] nums) {
        
        // This is a Greedy approach and we use BFS technique here
        int n = nums.length;

        int left, right, farthest, result;
        left = right = farthest = result = 0;

        // If right >= n - 1 we already got the answer in result variable
        while(right < n - 1)
        {
            // This variable will keep track of the farthest jump I could make at a level using BFS logic
            farthest = 0;

            // Assume at 0th index we have value 7 then the farthest move would be 0 + 7 = 7. We are doing this because we need to
            // find out the next maximum jump among the next level which has 7 children. We are being greedy in finding out the maximum
            // jump because that will give us minimum number of jumps possible
            for(int i = left; i <= right; i++) farthest = Math.max(farthest, i + nums[i]);

            // Assume previously right and left were at index 0 and now farthest became 7. So I need to check 7 children which
            // starts from index 1 till 7. So left becomes right + 1 and right becomes farthest
            left = right + 1;
            right = farthest;

            // At each level we are calculating the jumps
            result += 1;
        }

        return result;
    }
}