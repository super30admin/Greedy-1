// Time Complexity : O(N)

// Space Complexity : O(2N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using BFS, push the 0th node in the queue and the set. start exploring the children of 
// 0th node and add to queue keep track of the path. If the new idx to the last idx, return path. If not,
// check if its present in the set and add to set and queue.

// 55. Jump Game

import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int jump(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return 0;
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int level = 0;
        q.add(0);
        set.add(0);
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for(int j = 0;j<size;j++){
                int curr = q.poll();
                for(int i=1; i <= nums[curr]; i++){
                int newIdx = curr + i;
                if(newIdx == nums.length-1){
                    return level;
                } 
                if(!set.contains(newIdx)){
                    set.add(newIdx);
                    q.add(newIdx);
                }
            }
            }
        }
        return 0;
    }
}