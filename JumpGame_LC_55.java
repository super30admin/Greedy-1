/*
Time Complexity O(N)
Space Complexity O(1)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/

//Greedy on range
public class JumpGame_LC_55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n < 2 ) return true;
        int jumps = 1;
        int curInterval = nums[0];
        int nextInterval =nums[0];
        for(int i = 0; i< n ; i++) {
            nextInterval = Math.max(nextInterval, i + nums[i]);
            // System.out.print(i);
            if(i == curInterval){

                // if(curInterval == nextInterval) return false;
                curInterval = nextInterval;
            }
        }
        return curInterval >= n-1;
    }
}
/*
//DFS - TLE

class Solution1 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(nums.length < 2) return true;
        return dfs(nums, 0);
    }
    private boolean dfs(int [] nums, int idx) {
        //base
        if(idx == nums.length -1) return true;

        //logic
        for(int j = 1; j<=nums[idx]; j++){
            int newIdx = idx + j;
            if(dfs(nums, newIdx)) return true;
        }
    return false;
    }
}

//Optimised DFS - Accepted
class Solution2 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(nums.length < 2) return true;
        HashSet<Integer> memoSet = new HashSet<>();
        return dfs(nums, 0, memoSet);
    }
     private boolean dfs(int [] nums, int idx, HashSet<Integer> memoSet) {
        //base
        if(idx == nums.length -1) return true;
        if(memoSet.contains(idx)) return false;

        //logic
        for(int j = 1; j<=nums[idx]; j++){
            int newIdx = idx + j;
            if(dfs(nums, newIdx, memoSet)) return true;
        }
        memoSet.add(idx);
    return false;
    }
}


//DFS - Optimised HashMap
class Solution3 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(nums.length < 2) return true;
        HashMap<Integer, Boolean> memoSet = new HashMap<>();
        return dfs(nums, 0, memoSet);
    }
     private boolean dfs(int [] nums, int idx, HashMap<Integer, Boolean> memoSet) {
        //base
        if(idx >= nums.length -1) return true;
        if(memoSet.containsKey(idx)) return memoSet.get(idx);
        //logic
         int maxJump = Math.min(nums[idx], nums.length - 1 - idx);
        for(int j = maxJump; j>=1; j--){
            int newIdx = idx + j;
            if(dfs(nums, newIdx, memoSet)) {
                memoSet.put(idx, true);
                return true;
            }
        }
        memoSet.put(idx, false);
    return false;
    }
}

//Staring from end index
//Time complexity - O(N)
//Space Complexity - O(1)
class Solution4 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target = n-1;
        for(int i = n-2; i>=0 ; i--) {
            if(i + nums[i] >= target) {
                target = i;
            }
        }
    return target == 0;
    }
}
 */