package greedy1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGameII {
	//Greedy
	//Time Complexity : O(n), where n is the size of nums
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int jump(int[] nums) {
        if(nums.length <= 1)
            return 0;
        int curr = nums[0];
        int next = 0;
        int jumps = 1;
        
        for(int i=0; i<nums.length; i++) {
            if(curr >= nums.length - 1)
                return jumps;
            next = Math.max(next, nums[i] + i);
            if(i == curr) {
                jumps++;
                curr = next;
            }
        }
        
        return jumps;
    }
	
	//BFS Memo
	//Time Complexity : O(n^2), where n is the size of nums
	//Space Complexity : O(n), for queue
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int jump1(int[] nums) {
        // null
        if(nums == null || nums.length == 0)
            return 0;
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer(0);
        set.add(0);
        int jumps = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int curr = q.poll();
                if(curr >= nums.length - 1)
                    return jumps;
                for(int j=1; j<=nums[curr]; j++) {
                    if(curr + j >= nums.length -1)
                        return jumps + 1;
                    if(!set.contains(curr + j)) {
                        q.offer(curr + j);
                        set.add(curr + j);
                    }
                }
            }
            jumps++;
        }
        
        return 890;
    }
	
	//DFS memo
	//Time Complexity : O(n^2), where n is the size of nums
	//Space Complexity : O(n), for recursion stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int jump2(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs2(nums, 0, memo);
    }
    
    private int dfs2(int[] nums, int idx, int[] memo) {
        // base
        if(idx >= nums.length - 1)
            return 0;
        
        if(memo[idx] != -1)
            return memo[idx];

        int min = Integer.MAX_VALUE;
        for(int i=1; i<=nums[idx]; i++) {
            int res = dfs2(nums, idx + i, memo);
            min = Math.min(min, res);
        }
        
        if(min != Integer.MAX_VALUE)
            memo[idx] = min + 1;
        else
            memo[idx] = min;
        
        return memo[idx];
    }
	
	//DFS
	//Time Complexity : O(n^n), where n is the size of nums
	//Space Complexity : O(n), for recursion stack
	//Did this code successfully run on Leetcode : TLE
	//Any problem you faced while coding this : No
	int min = Integer.MAX_VALUE;
    public int jump3(int[] nums) {
        dfs3(nums, 0, 0);
        return min;
    }
    
    private void dfs3(int[] nums, int idx, int jumps) {
        // base
        if(idx >= nums.length - 1) {
            min = Math.min(min, jumps);
            return;
        }
        
        // logic
        for(int i=1; i<=nums[idx]; i++)
            dfs3(nums, idx + i, jumps+1);
    }
}
