import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGame {
    // Time Complexity :O(n) where n is the length of the nums array
    // Space Complexity :O(1) as no auxiliary space used
    // Did this code successfully run on Leetcode :yes
    public boolean canJump(int[] nums){
        int target = nums.length-1;
        for(int i = nums.length-2; i>=0; i--){
            if(i + nums[i] >= target){
                target = i;
            }
        }
        return target == 0;
    }

    //DFS with memoization
    // Time Complexity :
    // Space Complexity : O(n) where n is the
    // Did this code successfully run on Leetcode :yes
    private HashMap<Integer, Boolean> map;
    public boolean canJump2(int[] nums){
        if(nums == null || nums.length <= 1){
            return true;
        }
        this.map = new HashMap<>();
        return dfsWithDP(nums, 0);
    }


    private boolean dfsWithDP(int[] nums, int idx){
        //base
        if(idx >= nums.length -1){
            return true;
        }

        if(map.containsKey(idx)){
            return map.get(idx);
        }

        for(int i = nums[idx]; i>=1; i--){
            int nextIdx = idx+i;
            boolean result = false;
            if(!map.containsKey(nextIdx)){
                result = dfsWithDP(nums, nextIdx);
                map.put(nextIdx, result);
            }else{
                result = map.get(nextIdx);
            }
            if(result) return true;
        }
        return false;
    }

    //************BFS****************************
    // Time Complexity : O(k^n) in the worst case
    // Space Complexity : O(n) where n is the length of the nums array
    // Did this code successfully run on Leetcode :yes
    public boolean canJumpBFS(int[] nums) {
        if(nums == null || nums.length <= 1){
            return true;
        }

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(0);
        visited.add(0);

        while(!q.isEmpty()){
            int currentIdx = q.poll();
            if(currentIdx >= nums.length -1){
                return true;
            }
            for(int i = nums[currentIdx]; i>=1; i--){
                if(!visited.contains(currentIdx+i)){
                    q.add(currentIdx+i);
                    visited.add(currentIdx+i);
                }
            }
        }
        return false;
    }

    private boolean result;
    public boolean canJumpDFS(int[] nums) {

        if(nums == null || nums.length < 1){
            return true;
        }
        dfs(nums, 0);
        return result;
    }

    //*************************DFS****************************
    // Time Complexity : O(k^n) were k is the jump range at each step and n is the length of the nums array
    // Space Complexity : O(n) where n is the length of the nums array
    // Did this code successfully run on Leetcode :no, time limit exceeded
    private void dfs(int[] nums, int idx){
        //base
        if(idx >= nums.length -1){
            result = true;
            return;
        }

        if(nums[idx] == 0){
            return;
        }

        int maxJump = nums[idx];
        for(int i = maxJump; i>0; i--){
            if(!result){
                dfs(nums, idx+i);
            }
        }
    }
}
