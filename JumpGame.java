package greedy1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGame {
	//Greedy
	//Time Complexity : O(n), where n is the size of nums
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public boolean canJump(int[] nums) {
        int destination = nums.length - 1;
        
        for(int i=nums.length - 2; i>=0; i--) {
            if(i + nums[i] >= destination)
                destination = i;
        }
        
        return destination == 0;
    }
	
	//BFS Memo
	//Time Complexity : O(n^2), where n is the size of nums
	//Space Complexity : O(n), for queue
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public boolean canJump1(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(0);
        set.add(0);
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(curr >= nums.length - 1)
                return true;
            for(int i=1; i<=nums[curr]; i++) {
                if(curr + i >= nums.length - 1)
                    return true;
                if(!set.contains(curr + i)) {
                    queue.offer(curr + i);
                    set.add(curr + i);
                }
            }
        }
        
        return false;
    }
	
	//BFS
	//Time Complexity : O(n^n), where n is the size of nums
	//Space Complexity : O(n), for queue
	//Did this code successfully run on Leetcode : TLE
	//Any problem you faced while coding this : No
	public boolean canJump2(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(curr >= nums.length - 1)
                return true;
            for(int i=1; i<=nums[curr]; i++) {
                if(curr + i >= nums.length - 1)
                    return true;
                queue.offer(curr + i);
            }
        }
        
        return false;
    }
	
	//DFS memo
	//Time Complexity : O(n^2), where n is the size of nums
	//Space Complexity : O(n), for recursion stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public boolean canJump3(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs3(nums, 0, memo);
    }
    
    private boolean dfs3(int[] nums, int idx, int[] memo) {
        // base
        if(idx >= nums.length - 1)
            return true;
        
        if(memo[idx] != -1)
            return memo[idx] == 1;
        
        // logic
        for(int i=1; i<=nums[idx]; i++) {
            if(dfs3(nums, idx + i, memo)) {
                memo[idx] = 1;
                return true;
            }
        }
        memo[idx] = 0;
        
        return false;
    }
	
	//DFS
	//Time Complexity : O(n^n), where n is the size of nums
	//Space Complexity : O(n), for recursion stack
	//Did this code successfully run on Leetcode : TLE
	//Any problem you faced while coding this : No
	public boolean canJump4(int[] nums) {
        return dfs4(nums, 0);
    }
    
    private boolean dfs4(int[] nums, int idx) {
        // base
        if(idx >= nums.length - 1)
            return true;
        
        // logic
        for(int i=1; i<=nums[idx]; i++) {
            if(dfs4(nums, idx + i))
                return true;
        }
        
        return false;
    }
}
