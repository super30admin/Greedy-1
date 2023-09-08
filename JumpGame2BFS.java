// Time Complexity : O(k^n) -> k is the average number of jumps that can be made and n it the nums length
// Space Complexity : O(k^n)
// Did this code successfully run on Leetcode : Yes

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGame2BFS {

    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int jumps = 1;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(0);
        visited.add(0);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                int currIdx = q.poll();
                for(int j=1; j<=nums[currIdx]; j++)
                {
                    int newIdx = currIdx + j;
                    if(newIdx == nums.length - 1) return jumps;
                    if(!visited.contains(newIdx))
                    {
                        q.add(newIdx);
                        visited.add(newIdx);
                    }
                }
            }
            jumps++;
        }
        return -1;
    }
}
