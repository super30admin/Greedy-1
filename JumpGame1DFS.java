// Time Complexity : O(k^n) -> k is the average number of jumps that can be made and n it the nums length
// Space Complexity : O(k^n)
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;

public class JumpGame1DFS {

    HashMap<Integer, Boolean> map;
    public boolean canJump(int[] nums) {
        map = new HashMap<>();
        if(nums.length == 1) return true;
        return helper(nums, 0);
    }

    public boolean helper(int[] nums, int idx){

        if(idx == nums.length-1) return true;
        if(map.containsKey(idx)) return map.get(idx);
        for(int i=1; i<=nums[idx]; i++){
            int newIdx = idx + i;
            if(!map.containsKey(newIdx))
            {
                boolean re = helper(nums, newIdx) ;
                map.put(newIdx,re);
            }
            if(map.get(newIdx)) return true;
        }
        return false;
    }
}
