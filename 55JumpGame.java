/*
This problem has DFS ,DP approaches
Best approach is Greedy
*/
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length  < 2) return true;
        
        return dfs(nums,0);
    }
    
    private boolean dfs(int[] nums,int i ){
        //base last of nums
        if(i == nums.length -1 ){ //overshooting doesnt happen because we are incrementing by 1 so for 3 jumps to occur 2 jumps is processed first
            return true;
        }
        
        //logic
        //j starting 1 because atleast 1 jump
        for(int j = 1; j <= nums[i]; j++){
            if(dfs(nums,j+i)) return true;
          }
      return false;  
    }
}

/*Time :O(n^n)
Space : O(n) stack space
*/


/*Greedy*/

class Solution {
    public boolean canJump(int[] nums) {
      if(nums == null || nums.length  < 2) return true;
      int n = nums.length;
       
      int destination = n-1;
      
        for(int i = n-2;i>=0 ; i--){
            if(nums[i]+i >= destination){
                destination = i; //new destination is set to be reached
            }
        }
        if(destination == 0 ) return true;
        return false;
}
}
    
/*
Greedy O(n)
*/    