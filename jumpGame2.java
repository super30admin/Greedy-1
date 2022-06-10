/*
Problem: https://leetcode.com/problems/jump-game-ii/
*/

// Brute force
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);
        
        int jumps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; ++i) {
                int pos = queue.poll();
                
                for (int j = 1; j <= nums[pos]; ++j) {
                    int index = j + pos;
                    
                    if (index >= nums.length - 1)
                        return jumps;
                    
                    if (!visited.contains(index)) {
                        queue.add(index);
                        visited.add(index);
                    }
                }
            }
            ++jumps;
        }
        
        return 0;
    }
}

// Efficent:
// TC: O(n)
// SC: O(1)
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        int jumps = 0;
        int currentPos = nums[0];  // keeps track of end of the current interval
        int nextPos = nums[0];      // keeps track of the last position that can be reached by traversing until currentPos
        
        for (int i = 0; i < nums.length; ++i) {
            nextPos = Math.max(nextPos, i + nums[i]);
            
            if (i == currentPos) {
                ++jumps;
                currentPos = nextPos;
            }
            
            if (currentPos >= nums.length - 1) {
                return jumps + 1;
            }
        }
        
        return jumps;
    }
}