# Greedy-1

## Problem1 Jump Game (https://leetcode.com/problems/jump-game/)
## Time Complexity:O(N) Space Complexity:O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0; // Tracks the furthest index we can reach
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) {
                return false; // If current index is beyond the furthest reachable index, return false
            }
            reachable = Math.max(reachable, i + nums[i]); // Update reachable index
        }
        return true; // If we can traverse the entire array, return true
    }
}


           
## Problem2 Jump Game II (https://leetcode.com/problems/jump-game-ii/)
## Time Complexity:O(n2) Space:O(N)
class Solution {
    HashMap<Integer,Integer> memoMap;
    public int jump(int[] nums) {
        int n=nums.length;
        this.memoMap=new HashMap<>();
        if(n==1) return 0;
        return dfs(nums,0);
    }


    private int dfs(int[] nums,int currIdx)
    {
        if(currIdx>=nums.length-1)
        {
            return 0;
        }

        if(memoMap.containsKey(currIdx)) return memoMap.get(currIdx);

        int min=99999;
        for(int k=1;k<=nums[currIdx];k++)
        {
            int newIdx=currIdx+k;
            min=Math.min(min,1+dfs(nums,newIdx));
        }
        memoMap.put(currIdx,min);
        return min;


    }
}

## Problem3 Candy (https://leetcode.com/problems/candy/)
## Time Complexity:O(N) Space:O(1)
import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int n = ratings.length;
        int[] candies = new int[n];
        
        // Step 1: Initialize each child's candy count to 1
        Arrays.fill(candies, 1);

        // Step 2: Traverse from left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Step 3: Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Step 4: Sum up the candies
        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }

        return sum;
    }
}
