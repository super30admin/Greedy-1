//Problem 137: Jump Game II
//TC:O(N)
//SC:O(1)

/*Steps

  Bruteforce : 1) DFS : TC:Exponential. TLE 
               2) BFS : if visited not used then TC: exponential. If visited used TC:O(N). But still TLE

  Optimized : Greedy : Initialise two variables that are nextIntIdx & currIndIdx with first element of the array. On each traversal starting from second index of the array, find  nextIntIdx which is max of current index+element and itself. Once current index reaches the currIntIdx, assign nextIntIdx to currIntIdx and increase jump counter. Make sure this assignment and jump increment should be done only when the current index is not at the last index of the array.

           Eg:
              [3 4 2 1 1 2 2 1]             
         idx   0 1 2 3 4 5 6 7
         
         jumps | currIntervalIndx | nextIntervalIndx
           1           3                 3
           1           3                 5
           1           3                 5
           2           5                 5
           2           5                 5
           3           7                 7
           3           7                 8
*/


//Greedy
class Solution137 {
    public int jump(int[] nums) {
        //TC: O(N) || SC: O(1) 
        if(nums==null || nums.length<2) return 0;
        
        int nextIntIdx = nums[0];
        int currIntIdx = nums[0];//once i reaches it , breach happen u have to increase the jumps
        int jumps=1;
        for(int i=1;i<nums.length;i++){
            nextIntIdx = Math.max(nextIntIdx,i+nums[i]);
            
            if(i<nums.length-1 && i==currIntIdx){//if current interval index is at last index then no need to increase the jump counter
                currIntIdx = nextIntIdx;
                jumps++;
            }
            
        }
        
        return jumps;
    }
}




/* BFS : TLE
class Solution {
    public int jump(int[] nums) {
        
        if(nums==null || nums.length==0) return 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        
        Set<Integer> visited = new HashSet<>();
        
        int jumps=0;//levels
        
        while(!q.isEmpty()){
          int size = q.size();
            
            for(int i=0;i<size;i++){
                int idx = q.poll();
                
                if(idx>=nums.length-1) return jumps;
                
                for(int j=1;j<=nums[idx];j++){
                    if(!visited.contains(idx+j)) {
                        q.offer(idx+j);
                        visited.add(idx+j);
                    }
                }
            }
            jumps++;
        }
        
        return 0;
    }
}



*/


/* DFS :TLE

class Solution {
    int minJumps;
    public int jump(int[] nums) {
     
        if(nums==null || nums.length==0) return 0;
        minJumps = Integer.MAX_VALUE;
        dfs(nums,0,0);
        
        return minJumps;
    }
    
    private void dfs(int[] nums,int idx, int jumps){
        
        //base
        if(idx>=nums.length-1){
            minJumps = Math.min(minJumps,jumps);
            return;
        }
        
        //logic
        for(int j=1;j<=nums[idx];j++){
            
            dfs(nums,idx+j,jumps+1);
            
        }
        
        
    }
    
}



*/