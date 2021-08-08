package Greedy1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGame2 {
    /* Created by palak on 8/8/2021 */

    /**
         TC: O(N)
         SC: O(N)
     */
    HashSet<Integer> set;
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        Queue<Integer> queue = new LinkedList<>();
        set = new HashSet<>();
        queue.add(0);
        set.add(0);
        int jumps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int idx = queue.poll();
                for(int j = 1 ; j <= nums[idx] ; j++) {
                    int newIdx = idx + j;
                    if(!set.contains(newIdx)) {
                        if(newIdx >= nums.length - 1)   return jumps + 1;
                        queue.add(newIdx);
                        set.add(newIdx);
                    }
                }
            }
            jumps++;
        }
        return jumps;
    }


    /**
     TLE:
     TC: O(N)
     SC: O(N)
     */
    int min;
    public int jump2(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        min = Integer.MAX_VALUE;
        dfs(nums, 0, 0);
        return min;
    }
    private void dfs(int[] nums, int index, int jumps) {
        //Base
        if(index >= nums.length - 1) {
            min = Math.min(min, jumps);
            return;
        }
        //Logic
        for(int j = 1 ; j <= nums[index] ; j++) {
            dfs(nums, index + j, jumps + 1);
        }
    }

    /**

     TC: O(N)
     SC: O(N)
     */
    public int jump3(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int jumps = 1;
        int currInt = nums[0];
        int nextInt = nums[0];
        for(int i = 1 ; i < nums.length ; i++) {
            nextInt = Math.max(nextInt, nums[i] + i);
            if(i < nums.length - 1 && i == currInt) {
                jumps++;
                currInt = nextInt;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {

    }
}
