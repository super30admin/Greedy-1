class Solution {
    //O(N) time and O(1) space. GREEDY
    public int bestJump(int[] nums) {
        int jumps = 0, end = 0, maxDist = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && i > maxDist) 
                return -1; // to handle cases when last index cannot be reached.
            maxDist = Math.max(maxDist, nums[i] + i);
            if(i == end) {
                jumps++;
                end = maxDist;
            }
        }
        return jumps;
    }

    //O(2 ^ N) time and O(N) space. RECRUSION WITH MEMOIZATION 
    public int recursiveJump(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MAX_VALUE);
        return recrHelper(nums, 0, memo);
    }

    public int recrHelper(int[] nums, int index, int[] memo) {
        if(index >= nums.length - 1)
            return 0;
        
        if(memo[index] != Integer.MAX_VALUE)
            return memo[index];
        
        for(int s = nums[index]; s > 0; s--)  {
            int temp = recrHelper(nums, index + s, memo);
            if(temp != Integer.MAX_VALUE) 
                memo[index] = Math.min(memo[index],  temp + 1);
        }

        return memo[index];
    }

    //O(N ^ 2) time and O(N) space. DYNAMIC PROGRAMMING.
    public int dpJump(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MAX_VALUE);

        memo[n - 1] = 0;

        for(int index = n - 2; index >= 0; index--) 
            for(int s = nums[index]; s > 0; s--)
                if(index + s < n && memo[index + s] != Integer.MAX_VALUE)
                    memo[index] = Math.min(memo[index], memo[index + s] + 1);

        return memo[0];
    }

    //MAIN METHOD.
    public int jump(int[] nums) {
        return bestJump(nums);
        //return recursiveJump(nums);
        //return dpJump(nums);
    }
}
