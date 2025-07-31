/*
Time Complexity O(N)
Space Complexity O(N)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/


//Greedy From front , greedy on range
//Time Complexity - O(N)
// Space Complexity - O(1)
public class JumpGameII_LC_45 {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n < 2 ) return 0;
        int jumps = 1;
        int curInterval = nums[0];
        int nextInterval =nums[0];
        for(int i = 1; i< n ; i++) {
            nextInterval = Math.max(nextInterval, i + nums[i]);
            //if(nextInterval >= n-1) return jumps+1;
            if(i == curInterval){
                curInterval = nextInterval;
                if( i != n-1){
                    jumps++;
                }
            }
        }
        return jumps;
    }
}

/*
DFS with DP
Time Complexity - O(N)
Space Complexity - O(N)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n < 2 ) return 0;
        HashMap<Integer, Integer> memoMap = new HashMap<>();
        return dfs(nums, 0, memoMap);

    }
    private int dfs(int [] nums,int idx, HashMap<Integer, Integer> memoMap ){
        if(idx >= nums.length-1) return 0;
        if(memoMap.containsKey(idx)) return memoMap.get(idx);
        int min = 999999;
        for(int j =1; j<= nums[idx]; j++) {
            int newIdx = idx + j;
            int currJumps = dfs(nums, newIdx, memoMap);
            min = Math.min(min, currJumps);

        }
        memoMap.put(idx, min+1);
        return min+1;
    }
}

 */