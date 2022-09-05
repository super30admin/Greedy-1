//Time Complexity- O(n)
//Space Complexity - O(1)
//Sucessfully ran on leetcode

class Solution {
   
 public boolean canJump(int[] nums) {
     if(nums.length< 2) return true;
     
    //Greedy
     int n = nums.length;
      int destination = n-1;
     for(int i= n-2 ; i>= 0; i--){
         if(nums[i]+i >= destination){
             destination = i;
         }
     }
     
             return destination==0;
 }
}


     //bfs solution
//         Queue<Integer> q = new LinkedList<>();
//         HashSet<Integer> visited = new HashSet<>();
//         q.add(0);
     
//         while(!q.isEmpty()){
         
//             int curr = q.poll();
//             for(int i =0; i<= nums[curr] ; i++){
//                int next = curr + i;
             
//                 if(next == nums.length-1) return true;
             
//                 if(!visited.contains(next)){
//                 visited.add(next);
//                 q.add(next);
//                 }
//             }
//         }
//         return false;
