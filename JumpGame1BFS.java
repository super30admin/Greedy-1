// Time Complexity : O(k^n) -> k is the average number of jumps that can be made and n it the nums length
// Space Complexity : O(k^n)
// Did this code successfully run on Leetcode : Yes

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGame1BFS {
    public boolean canJump(int[] nums) {
        if(nums.length <=1) return true;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(0);

        while(!q.isEmpty()){
            int currIdx = q.poll();
            for(int i=1; i<= nums[currIdx]; i++)
            {
                int newIdx = currIdx + i;
                if(newIdx == nums.length-1) return true;
                if(!visited.contains(newIdx))
                {
                    visited.add(newIdx);
                    q.add(newIdx);
                }
            }
        }
        return false;
    }
}
