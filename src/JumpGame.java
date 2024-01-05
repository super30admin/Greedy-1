// Time Complexity:  O(n)
// Space Complexity: O(1)

// ******************** Greedy ********************

class Solution {
    
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        if(n==1) return true;
    
        int ind = n-1;                       // set last index

        for(int i=ind-1; i>=0; i--) {
            if(i+nums[i] >= ind) {           // whenever (i+nums[i]) >= index
                ind = i;                     // change index
            }
        }

        return ind==0;                       // if you reached index 0, then true

    }

}







// // ******************** Greedy Another Approach ********************

// // Time Complexity:  O(n)
// // Space Complexity: O(1)

// class Solution {
    
//     public boolean canJump(int[] nums) {
        
//         int n = nums.length;
//         if(n==1) return true;
    
//         int ind = n-1;                       // set last index
//         int val = nums[ind];                 // set last value

//         for(int i=ind-1; i>=0; i--) {
//             if(i+nums[i] >= ind) {           // whenever (i+nums[i]) >= index
//                 ind = i;                     // change index
//                 val = nums[i];               // change value
//             }
//         }

//         return ind==0;                       // if you reached index 0, then true

//     }

// }






// // ******************** BFS ********************

// // Time Complexity:  O(n^2)
// // Space Complexity: O(n)

// class Solution {
    
//     public boolean canJump(int[] nums) {
        
//         int n = nums.length;
//         if(n==1) return true;
    
//         Queue<Integer> q = new LinkedList<>();
//         Set<Integer> set = new HashSet<>();

//         q.add(0);
//         set.add(0);

//         while(!q.isEmpty()) {
//             int idx = q.poll();
//             for(int j=1; j<=nums[idx] ; j++) {          // loop from next to curr idx to nums[idx] length
//                 int newIdx = idx+j;                     // get newIdx every time
//                 if(newIdx >= n-1)                       // if greater than length then return true
//                     return true;
//                 if(!set.contains(newIdx)) {             // if not in set
//                     q.add(newIdx);                      // add in queue, and set
//                     set.add(newIdx);
//                 }
//             }
//         }

//         return false;

//     }

// }






// // ******************** DP : DFS ********************

// // Time Complexity:  O(n^2)
// // Space Complexity: O(n)

// class Solution {

//     int[] dp;
    
//     public boolean canJump(int[] nums) {
        
//         int n = nums.length;
//         if(n==1) return true;

//         dp = new int[n-1];
    
//         return dfs(nums, 0);

//     }

//     private boolean dfs(int[] nums, int ind) {

//         if(dp[ind]!=0) {
//             if(dp[ind]==2) return true;
//             return false;
//         }

//         for(int j=1; j<=nums[ind]; j++) {
//             int newInd = ind+j;
//             if(newInd >= nums.length-1) 
//                 return true;
//             if(dfs(nums, newInd)) {
//                 dp[newInd] = 2;
//                 return true;
//             }
//             dp[newInd] = 1;
//         }

//         return false;

//     }

// }
