// Time Complexity : O(k^n) -> k is the average number of jumps that can be made and n it the nums length
// Space Complexity : O(k^n)
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;

public class JumpGame2UsingDFS {
    HashMap<Integer, Integer> map;
    public int jump(int[] nums) {
        map = new HashMap<>();
        if(nums.length == 1) return 0;
        return  helper(nums,0);
    }

    public int helper(int[] nums, int idx){

        if(idx >= nums.length-1) return 0;
        int  minJumps = 99999;
        for(int i=1; i<=nums[idx]; i++)
        {
            int newIdx = idx + i;
            if(!map.containsKey(newIdx))
            {
                int jumpsFromBaby = helper(nums,newIdx);
                map.put(newIdx, jumpsFromBaby);
            }

            minJumps = Math.min(minJumps, map.get(newIdx));

        }

        return minJumps+1;
    }
}
