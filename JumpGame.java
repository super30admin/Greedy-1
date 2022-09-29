// Time Complexity : O(n) where n = length of nums array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//55. Jump Game (Medium) - https://leetcode.com/problems/jump-game/
// Time Complexity : O(n power k) where n = number of elements, k = average number of decisions at every node
// Space Complexity : O(n) where n = number of elements
//class Solution {
//    public boolean canJump(int[] nums) {
//    	// Optimized BFS
//        if (nums.length < 2) return true;
//        
//        int n = nums.length-1;
//        
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(0);
//        
//        HashSet<Integer> set = new HashSet<>();
//        set.add(0);
//        
//        while (!queue.isEmpty()) {
//            int i = queue.poll();
//            
//            for (int j = 1; j <= nums[i]; j++) {
//                int newIndex = i + j;
//                
//                if (newIndex >= n) return true;
//                
//                if (!set.contains(newIndex)) {
//                    queue.add(newIndex);
//                    set.add(newIndex);
//                }
//            }
//        }
//        
//        return false;
//    }
//}

//Time Complexity : O(n) where n = length of nums array
//Space Complexity : O(1)
class Solution {
 public boolean canJump(int[] nums) {
     if (nums.length < 2) return true;
     
     int target = nums.length-1;
     
     for (int i = nums.length-2; i >= 0; i--) {
         if (i + nums[i] >= target) {
             target = i;
         }
     }
     
     return target == 0;
 }
}