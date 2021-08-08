package Greedy1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGame {
    /* Created by palak on 8/8/2021 */

    /**
     BFS Solution:
     Time Complexity: O(n)
     Space Complexity: O(n)
     */
    HashSet<Integer> set;
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        Queue<Integer> queue = new LinkedList<>();
        set = new HashSet<>();
        queue.add(0);
        set.add(0);
        while(!queue.isEmpty()) {
            int idx = queue.poll();
            for(int j = 1 ; j <= nums[idx] ; j++) {
                int newIdx = idx + j;
                if(!set.contains(newIdx)) {
                    if(newIdx == nums.length - 1)   return true;
                    queue.add(newIdx);
                    set.add(newIdx);
                }
            }
        }
        return false;
    }

    /**
     DFS Solution:
     Time Complexity: O(n)
     Space Complexity: O(n)
     */

    HashSet<Integer> set1;
    public boolean canJump1(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        set1 = new HashSet<>();
        return dfs(0, nums);
    }
    private boolean dfs(int index, int[] nums) {
        //Base
        if(index == nums.length - 1)    return true;
        if(set1.contains(index)) return false;

        //Logic
        set1.add(index);
        for(int j = 1 ; j <= nums[index]; j++) {
            if(dfs(index + j, nums))    return true;
        }
        return false;
    }

    /**
         Starting from the last:
         Time Complexity: O(n)
         Space Complexity: O(n)
     */
    public boolean canJump2(int[] nums) {
        if(nums == null || nums.length < 2) return true;
        int destination = nums.length - 1;
        for(int i = nums.length - 2; i >= 0 ; i--) {
            if(destination <= nums[i] + i) {
                destination = i;
            }
        }
        return destination == 0;
    }

    public static void main(String[] args) {

    }
}