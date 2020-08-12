<------Brute Force---->
// Time Complexity : O(n^2) 
// Space Complexity : O(n) 

class jumpGame2 {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {            
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i)
                    min = Math.min(min, dp[j]);    
            }
            dp[i] = min + 1;
        }
        return dp[nums.length - 1];
    }
} 

<-----Greedy----->

// Time Complexity : O(n)
// Space Complexity : O(1) 

class jumpGame2 {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int nextInt = nums[0], currInt = nums[0], jumps = 1;
        for (int i = 1; i < nums.length; i++) {
            nextInt = Math.max(nextInt, i + nums[i]);
            if (i < nums.length - 1 && currInt == i) {                
                currInt = nextInt;
		jumps++;
            }
        }
        return jumps;
    }
} 