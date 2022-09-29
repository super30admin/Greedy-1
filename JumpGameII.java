import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(n*k) where n = length of nums array, k = average number of decisions at every node
// Space Complexity : O(n) where n = length of nums array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//45. Jump Game II (Medium) - https://leetcode.com/problems/jump-game-ii/
// Time Complexity : O(n*k) where n = length of nums array, k = average number of decisions at every node
// Space Complexity : O(n) where n = length of nums array
class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2) return 0;
        
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        int jumps = 1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for (int k = 0; k < size; k++) {
                int i = queue.poll();
                
                for (int j = 1; j <= nums[i]; j++) {
                    int newIndex = i + j;
                    
                    if (newIndex >= nums.length-1) return jumps;
                    
                    if (!set.contains(newIndex)) {
                        set.add(newIndex);
                        queue.add(newIndex);
                    }
                }
            }
            
            jumps++;
        }
        
        return -1;
    }
}