// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// class Solution {
//     public int jump(int[] nums) {
//         if(nums.length <= 1) return 0;
//         Queue<Integer> q = new LinkedList<>();
//         HashSet<Integer> set = new HashSet<>();
//         set.add(0);
//         q.add(0);
//         int jumps = 0;
//         while(!q.isEmpty()) {
//             int size = q.size();
//             for(int j=0; j<size;j++) {
//                 int currIdx = q.poll();
//                 for(int i=1; i<=nums[currIdx]; i++) {
//                     int newIdx = currIdx+i;
//                     if(newIdx >= nums.length-1) return jumps+1;
//                     if(!set.contains(newIdx)) {
//                         q.add(newIdx);
//                         set.add(newIdx);
//                     }
//                 }
//             }
//             jumps++;
//         }
//         return 12;
//     }
// }
// class Solution {
//     HashMap<Integer, Integer> map;
//     public int jump(int[] nums) {
//         if(nums.length <= 1) return 0;
//         this.map = new HashMap<>();
//         return dfs(nums, 0);
//     }
//     private int dfs(int[] nums, int idx) {
//         //base case
//         if(idx >= nums.length-1) return 0;

//         //logic
//         int min = 99999;
//         for(int i = 1; i <= nums[idx]; i++) {
//             int newIdx = i+idx;
//             if(!map.containsKey(newIdx)) {
//                 int jumps = dfs(nums, newIdx);
//                 map.put(newIdx, jumps);
//             }
//             min = Math.min(min, map.get(newIdx));
//         }
//         map.put(idx, min+1);
//         return min+1;
//     }
// }
class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1) return 0;
        int currInterval = nums[0];
        int maxInterval = nums[0];
        int jumps = 1;
        for(int i = 1; i < nums.length; i++) {
            maxInterval = Math.max(maxInterval, i+nums[i]);
            if(currInterval < nums.length-1 && i == currInterval) {
                jumps++;
                currInterval = maxInterval;
            }
            
        }
        return jumps;
    }
}