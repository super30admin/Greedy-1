import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGameII {
    //optimal solution
    // Time Complexity :O(n) where n is the length of the nums array
    // Space Complexity :O(1) no auxiliary space used
    // Did this code successfully run on Leetcode :yes
    public int jump(int[] nums){
        if(nums.length < 2){
            return 0;
        }

        int currentInterval = nums[0];
        int nextInterval = nums[0];
        int jumps = 1;

        for(int i = 1; i<nums.length-1; i++){
            nextInterval = Math.max(nextInterval, i+nums[i]);
            if(i == currentInterval){
                jumps++;
                currentInterval = nextInterval;
            }
        }
        return jumps;
    }

    //DFS with memoization
    // Time Complexity :O(k^n) where k is the average no of jumps at each level, n = nums.length
    // Space Complexity :O(n)
    // Did this code successfully run on Leetcode :yes
    private HashMap<Integer, Integer> map;
    public int jumpDFSDP(int[] nums){
        if(nums.length < 2) return 0;
        this.map = new HashMap<>();
        return dfsDP(nums, 0);
    }

    private int dfsDP(int[] nums, int idx){
        //base
        if(idx == nums.length -1){
            return 0;
        }

        int min = 999999;
        for(int j = 1; j<= nums[idx] && idx+j < nums.length; j++){
            int nIdx = idx +j;
            int temp = 0;
            if(!map.containsKey(nIdx)){
                temp = dfsDP(nums, nIdx);
                map.put(nIdx, temp);
            }
            temp = map.get(nIdx);
            min = Math.min(min, temp);
        }
        return min +1;
    }

    //DFS
    // Time Complexity :O(k^n) where k is the average no of jumps at each level, n = nums.length
    // Space Complexity :O(n)
    // Did this code successfully run on Leetcode :yes
    private int minJumps;
    public int jumpDFS(int[] nums){
        if(nums.length < 2){
            return 0;
        }
        this.minJumps = Integer.MAX_VALUE;
        dfs(nums, 0, 0);
        return minJumps;
    }

    private void dfs(int[] nums, int idx, int numberOfJumps){
        if(idx >= nums.length-1){
            minJumps = Math.min(minJumps, numberOfJumps);
            return;
        }

        for(int i = nums[idx]; i>=1; i--){
            dfs(nums, idx+i, numberOfJumps+1);
        }
    }

    //BFS
    // Time Complexity :O(k^n) where k is the average no of jumps at each level, n = nums.length
    // Space Complexity :O(n)
    // Did this code successfully run on Leetcode :yes
    public int jumpBFS(int[] nums) {
        if(nums.length <2) return 0;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        q.add(0);
        set.add(0);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int current = q.poll();
                for(int j = nums[current]; j>=1; j--){
                    if(current + j >= nums.length-1){
                        return count +1;
                    }
                    if(!set.contains(current +j) && nums[current + j]!= 0){
                        q.add(current+j);
                        set.add(current+j);
                    }
                }
            }
            count++;
        }
        return 99999;
    }
}
