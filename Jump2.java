// Time Complexity : O(n)
// Space Complexity : O(n) for queue. can be done in O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class Jump2 {
    public int jump(int[] nums) {
        int level = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        while(!q.isEmpty()){
            //System.out.println(q);
            int size = q.size();
            for(int j=0;j<size;j++){
                int idx = q.poll();

                if(idx>=nums.length-1)return level;
                for(int i=idx+1;i<=idx+nums[idx];i++){
                    if(!set.contains(i)) {q.add(i);set.add(i);}
                }
            }
            level++;
        }
        return -1;
    }
}