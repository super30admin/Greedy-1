// Time Complexity : O(exponential)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

class jump2BFS {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;
        
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        //add 0 to both to begin
        q.add(0);
        visited.add(0);
        int jumps = 0;
        
        while(!q.isEmpty()){
            //keep track of size
            int sz = q.size();
            
            for(int j = 0; j < sz; j++){
                int index = q.poll();

                for(int i = 1; i <= nums[index]; i++){
                    int numIndex = index + i;

                    if(!visited.contains(numIndex)){

                        //if we reached the end then we return the jumps
                        if(numIndex == nums.length - 1)
                            return jumps+ 1;
                        
                        q.add(numIndex);
                        visited.add(numIndex);
                    }
                }
            }
            //after we iterate through each level, we increment jumps
            jumps++;
        }
        return jumps;
    }
}