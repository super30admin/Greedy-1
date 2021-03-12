//Problem 136: Jump Game
//TC:O(N)
//SC:O(1)

/*Steps

  Bruteforce : 1) DFS : TC:Exponential. TLE 
               2) BFS : TC:Exponential. TLE

  Optimized : Greedy : Make destination to the last index. Start your traversal from the last-1 index. Then find whether from that index you can reach the next index. This is done by adding the index and the current element. If there is reachability then just update the destination to the current index and decrement your current pointer/traversal
*/


//Greedy
class Solution136 {
    public boolean canJump(int[] nums) {
        
        if(nums==null || nums.length==0) return false;
        //TC:O(N) | SC:O(1)
        int destination = nums.length-1;
        for(int j=nums.length-2;j>=0;j--){
            
            if(nums[j]+j>=destination){//means you can reach next index
                //change destination to current index;
                destination = j;
            }
            
        }
        
        return destination==0;
    }
}



/* BFS : TLE
class Solution {
    public boolean canJump(int[] nums) {
        
        if(nums==null || nums.length==0) return false;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        while(!q.isEmpty()){
            int idx = q.poll();
            
            if(idx>=nums.length-1) return true;
            
            for(int j=1;j<=nums[idx];j++){//jumps
                q.offer(idx+j);
            }
            
        }
        
        return false;
    }
}

*/


/* DFS :TLE

class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0) return false;
        //TC:Exponential, because we are exploring all the paths
        return  dfs(nums,0);
    }
    
    private boolean dfs(int[] nums, int idx){
        
        //base
        if(idx>=nums.length-1) return true;// because suppose at second last index if there is 5, then also it can go out of boundi.e return true;
        
        for(int j=1;j<=nums[idx];j++){//number of jumps
             if(dfs(nums,idx+j)) return true;
        }
    
     return false;   
  }
    
}



*/