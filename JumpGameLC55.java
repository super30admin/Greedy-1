class Solution {
    
    //Greedy Approach 2
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    
    public boolean canJump(int[] nums) {
        
        int max = 0;                                    //store the maximum jump we can do from the earlier locations that are visited
        int i = 0;                                      //we are at first index so
        
        while(i<=max){                                  //iterate till i<= max
            
            max = Math.max(i + nums[i], max);           //get the max value between i+nums[i](means from currentIndex+ how far we can jump from that place) and max and give it to max
            if(max>= nums.length-1){                    //check if max reaches to the end of the array
                return true;                            //then return true
            }
            i++;                                        //increase the i index
   
        }   
        return false;                                   //means we can't reach to the end
    }

    
    
    
    //Greedy Approach 2
    //Time Complexity: O(n)
    //Space Complexity: O(1)
//     public boolean canJump(int[] nums) {
        
//         int i=nums.length - 2;
//         int d = nums.length - 1;
        
//         while(i>=0){
            
//             if(i+nums[i] >=d){
//                 d = i;
//             }
//             i--;
   
//         }
//         return d==0;
        
//     }
    
    

    
    //Dp approach 2, bottom Up
    //Time Complexity : O(n+ sum(nums))
    //Space Complexity: O(n)
//     public boolean canJump(int[] nums) {
       
//         boolean[] dp = new boolean[nums.length];
//         dp[nums.length - 1] = true;
        
//         for(int i = nums.length - 2; i>=0; i--){
            
//             int maxJump = nums[i];
            
//             for(int j= i+1; j<= i+ maxJump; j++){
//                 if(dp[j]){
//                     dp[i]  = true;
//                     break;
//                 }
//             }
            
//         }
     
//         return dp[0];
//     }
    
    
    
    
    
    //DP approach, Top Down, Time Limit Exceed Error
    //Time Complexity : O(n*n)
    //Space Complexity : O(n)
//     Map<Integer, Boolean> map;
//     public boolean canJump(int[] nums) {
       
//         map = new HashMap<>();
     
//         return helper(nums, 0);
//     }
    
//     private boolean helper(int[] nums, int index){
        
//         if(map.containsKey(index)){
//             return map.get(index);
//         }
        
//         if(index== nums.length - 1){
//             map.put(index, true);
//             return true;
//         }
        
//         for(int i = index+1; i<= index + nums[index]; i++){
//             if(helper(nums, i)){
//                 return true;
//             }
//         }
        
//         return false;
        
        
//     }
  
    
    
    //Recursive Approach, Time Limit Exceed Error
    //Time Complexity: O(n!)
    //Space Complexity: O(n)
//     boolean flag;
//     public boolean canJump(int[] nums) {
        
//         flag = false;
//         helper(nums, 0);
//         return flag;
//     }
    
//     private void helper(int[] nums, int index){
        
//         if(flag){
//             return;
//         }
        
//         if(index== nums.length - 1){
//             flag = true;
//             return;
//         }
        
//         for(int i = index+1; i<= index + nums[index]; i++){
//             helper(nums, i);
//         }
        
        
//     }
    
    
}
