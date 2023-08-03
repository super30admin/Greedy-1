// Greedy approach from back -- O(n) solution -- at every point starting from back check whether the prev element + prev element index reaches/crosses the target. If yes prev element index becomes the new target. else check the next previous element
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length - 1;
        int target = n;
        for(int i=n-1;i>=0;i--){
            if(i+nums[i] >= target){
                target = i;
            }
        }
        if(target==0) return true;
        return false;
    }
}

// // BFS Solution TC = exponential
// class Solution {
//     public boolean canJump(int[] nums) {
//         Queue<Integer> q = new LinkedList<>();
//         HashSet<Integer> visited = new HashSet<>();
//         q.add(0);
//         while(!q.isEmpty()){
//             int currIdx = q.poll();
//             for(int i=0;i<=nums[currIdx];i++){
//                 int newIdx = i + currIdx;
//                 if(newIdx == nums.length-1) return true;
//                 if(!visited.contains(newIdx)){
//                     q.add(newIdx); visited.add(newIdx);
//                 }
//             }
//         }
//         return false;
//     }
// }

// // DFS Solution TC = exponential
// class Solution {
//     boolean flag;
//     public boolean canJump(int[] nums) {
//         if(nums.length<=1) return true;
//         flag = false;
//         dfs(nums, 0);
//         return flag;
//     }
//     private void dfs(int[] nums, int currIdx){
//         // base
//         if(flag) return;
//         // logic
//         for(int i=1;i<=nums[currIdx];i++){
//             int newIdx = currIdx + i;
//             if(newIdx >= nums.length-1) flag = true;
//             dfs(nums,newIdx);
//         }
//     }
// }

// // DFS Solution TC = O(nk) with DP map 
// class Solution {
//     HashMap<Integer,Boolean> map;
//     public boolean canJump(int[] nums) {
//         map = new HashMap<>();
//         if(nums.length<=1) return true;
//         return dfs(nums, 0);
//     }
//     private boolean dfs(int[] nums, int currIdx){
//         // base
//         if(currIdx >= nums.length-1) return true;
//         // logic
//         for(int i=1;i<=nums[currIdx];i++){
//             int newIdx = currIdx + i;
//             boolean result = false;
            
//             if(!map.containsKey(newIdx)){
//                 map.put(newIdx,dfs(nums,newIdx));    
//             }
//             result = map.get(newIdx);
//             if(result) return true;
//         }
//         return false;
//     }
// }
