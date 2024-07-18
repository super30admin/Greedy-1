/// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No
//BFS
// class Solution {
//     public boolean canJump(int[] nums) {
//         if(nums.length <= 1) return true;
//         Queue<Integer> q = new LinkedList<>();
//         HashSet<Integer> set = new HashSet<>();
//         set.add(0);
//         q.add(0);
//         while(!q.isEmpty()) {
//             int currIdx = q.poll();
//             for(int i=1; i<=nums[currIdx]; i++) {
//                 int newIdx = currIdx+i;
//                 if(newIdx >= nums.length-1) return true;
//                 if(!set.contains(newIdx)) {
//                     q.add(newIdx);
//                     set.add(newIdx);
//                 }
//             }

//         }
//         return false;
//     }
// }

//DFS
// class Solution {
//     HashSet<Integer> set = new HashSet<>();
//     public boolean canJump(int[] nums) {
//         if(nums.length <= 1) return true;
//         return dfs(nums,0);
//     }
//     private boolean dfs(int[] nums, int idx) {
//         //base case
//         if(idx >= nums.length-1) return true;
//         if(set.contains(idx)) return false;

//         //logic
//         for(int i = 1; i <= nums[idx]; i++) {
//             int newIdx = idx+i;
//             if(dfs(nums,newIdx)) return true;
//         }
//         set.add(idx);
//         return false;
//     }
// }


//Greedy
class Solution {
    public boolean JumpGameI(int[] nums) {
        int n = nums.length;
        int target = n-1;
        for(int i = n-2; i >= 0; i--) {
            if(i+nums[i] >= target) {
                target = i;
            }
            
        }
        return target == 0;
    }
}