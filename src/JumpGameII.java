// Time Complexity:  O(n)
// Space Complexity: O(1)

// ******************** Greedy Solution ********************

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;
        int jumps = 1;
        int currInt = nums[0];
        int nextInt = nums[0];
        for(int i=1; i<nums.length; i++) {
            nextInt = Math.max(nextInt, i + nums[i]);      // update nextInt
            if(i == currInt && i != n-1) {                 // if we reach currInt, and it is not end
                jumps++;                                   // then increment jumps
                currInt = nextInt;                         // and update currInt
            }
        }
        return jumps;
    }
}







// // Time Complexity:  O(n)
// // Space Complexity: O(n)

// // ******************** BFS Solution ********************

// class Solution {
    
//     public int jump(int[] nums) {
        
//         int n = nums.length;
//         if(n < 2) return 0;
        
//         int jumps = 0;
//         Queue<Integer> queue = new LinkedList<>();
//         Set<Integer> set = new HashSet<>();

//         queue.add(0);                                            // adding index 0
//         set.add(0);

//         while(!queue.isEmpty()) {                                // iterate queue

//             int size = queue.size();                 
//             while(size-- > 0) {
//                 int curr = queue.poll();                         // get num from queue one by one
//                 if(curr == n-1) return jumps;                    // last index, then return jumps
//                 for(int j=1; j<=nums[curr]; j++) {               // go upto next nums[curr] indexes
//                     int newNum = curr + j;       
//                     if(!set.contains(newNum)) {                  // add only if not in set
//                         queue.add(newNum);
//                         set.add(newNum);
//                     }
//                 }
//             }
//             jumps++;                                             // increment jumps
            
//         }
        
//         return jumps;

//     }

// }







// // Time Complexity:  O(n)
// // Space Complexity: O(n)

// // ******************** DFS Solution : without DP ********************

// class Solution {

//     int min;
    
//     public int jump(int[] nums) {
        
//         int n = nums.length;
//         if(n < 2) return 0;
        
//         min = Integer.MAX_VALUE;
//         dfs(nums, 0, 0);
//         return min;

//     }

//     private void dfs(int[] nums, int index, int jumps) {

//         if(index >= nums.length-1) {                            // end of array
//             min = Math.min(min, jumps);                         // update min and return
//             return;
//         }
        
//         for(int j=1; j<=nums[index]; j++) {                     // go through nums[index] range
//             int newNum = index+j;               
//             dfs(nums, newNum, jumps+1);                         // recursion
//         }

//     }

// }









// // Time Complexity:  O(n)
// // Space Complexity: O(n)

// // ******************** DFS Solution : with DP ********************

// class Solution {

//     Map<Integer, Integer> map;
    
//     public int jump(int[] nums) {
        
//         int n = nums.length;
//         if(n < 2) return 0;

//         map = new HashMap<>();
        
//         return dfs(nums, 0);

//     }

//     private int dfs(int[] nums, int index) {

//         if(index >= nums.length-1) {                                    // end of array
//             return 0;                                                   // return 0;
//         }

//         if(map.containsKey(index)) {                                    // if map has it,
//             return map.get(index);                                      // return value
//         }

//         int min = 999999;                                               // initialized with value greater than MAX_VAL from range
//         for(int j=1; j<=nums[index]; j++) {                             // go through nums[index] range
//             int newNum = index+j;   
//             min = Math.min(min, dfs(nums, newNum));                     // update min with recursion
//         }
//         map.put(index, min+1);                                          // update map and return it
//         return map.get(index);
//     }

// }

