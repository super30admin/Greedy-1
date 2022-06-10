/*
Problem: https://leetcode.com/problems/jump-game/
*/

// Brute force: BFS - very slow
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        
        while (!queue.isEmpty()) {
            int startPos = queue.poll();
            for (int i = 1; i <= nums[startPos]; ++i) {
                int index = i + startPos;
                
                if (index == nums.length - 1)
                    return true;
                
                if (!visited.contains(index)) {
                    visited.add(index);
                    queue.add(index);
                }
            }   
        }
        
        return false;
    }
}


// Efficient
// TC: O(n)
// SC: O(1)
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        
        int n = nums.length;
        int destination = n - 1;
        
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] + i >= destination) {
                destination = i;
            }
        }
        
        return destination == 0;
    }
}