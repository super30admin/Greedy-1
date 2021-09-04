// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    //BFS
    /*
    public boolean canJump(int[] nums) {
        
        if(nums.length==0||nums==null)
            return false;
        
        if(nums.length==1)
            return true;
        
        Set<Integer> visited=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        visited.add(0);
        
        while(!queue.isEmpty())
        {
            int index=queue.poll();
            
             for(int i=1;i<=nums[index];i++)
             {
                 int newIndex=index+i;
                 
                 if(newIndex==nums.length-1)
                     return true;
                 if(!visited.contains(newIndex))
                 {
                     queue.add(newIndex);
                     visited.add(newIndex);
                 }
             }
        }
        return false;
    }
    */
    
    //DFS
    /*
    Set<Integer> visited;
     public boolean canJump(int[] nums) {
        
        if(nums.length==0||nums==null)
            return false;
        
        if(nums.length==1)
            return true;
         
         visited=new HashSet<>();
        return  dfs(0,nums);
     }
    
    private boolean dfs(int index,int[] nums)
    {
        //base
        if(visited.contains(index))
            return false;
        if(index==nums.length-1)
            return true;
        
        //logic
        visited.add(index);
        for(int i=1;i<=nums[index];i++)
        {
            if(dfs(index+i,nums))return true;
        }
        return false;
    }
    */
    
    // Greedy
    public boolean canJump(int[] nums) {
        
        if(nums.length==0||nums==null)
            return false;
        
        if(nums.length==1)
            return true;
        
        int n=nums.length;
        int destination=nums.length-1;
        
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]+i>=destination)
                destination=i;
               
        }
        return destination==0;
    }
}
public class Problem2_JumpGame {

}
