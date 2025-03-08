//TC: O(n)
//SC: O(n)
//approach: bfs

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumGame2Bfs {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int curr = q.poll();
                if(curr>=nums.length-1) return level;
                for(int j=1;j<=nums[curr];j++){
                    if(!set.contains(curr+j)){
                        q.add(curr+j);
                        set.add(curr+j);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
