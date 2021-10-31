// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// start from the end and set destination to n-1 index, then check that if the index less then destination + its value can reach the des, if so set the index as new destination and return true if last destination is 0 else false
// Your code here along with comments explaining your approach
// linear
class Solution {
    public boolean canJump(int[] nums) {
        if( nums == null || nums.length < 2) return true;
        int des = nums.length-1;
        for(int i = nums.length-2; i>=0; i--){
            if(i+nums[i]>= des) des = i;
        }
        return des == 0;
    }
}
// // dfs
// class Solution {
//     HashSet<Integer> set;
//     public boolean canJump(int[] nums) {
//         if( nums == null || nums.length < 2) return true;
//         set = new HashSet<>();
//         return helper(0, nums);
//     }
//     private boolean helper(int idx, int [] nums){
//         //base
//         if( idx >= nums.length-1) return true;
//         //logic
//         set.add(idx);
//         for( int i = 1; i<= nums[idx]; i++){
//            if(!set.contains(idx+i) && helper(idx + i, nums)) return true;
//         }
//         return false;
//     }
// }

// // bfs
// class Solution {
//     public boolean canJump(int[] nums) {
//         if( nums == null || nums.length < 2 ) return true;
//         Queue<Integer> q = new LinkedList<>();
//         HashSet<Integer> hs = new HashSet<>();
//         q.add(0);
//         hs.add(0);
//         while(!q.isEmpty()){
//             int idx = q.poll();
//             for( int j = 1; j <= nums[idx]; j++){
//                 int i = idx + j;
//                 if(!hs.contains(i)){
//                     if( i >= nums.length - 1 ) return true;
//                     q.add(i);
//                     hs.add(i);
//                 }
//             }
//         }
//         return false;
//     }
// }