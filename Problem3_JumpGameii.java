// Time Complexity : o(N)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int jump(int[] nums) {
        
         if(nums.length<2||nums==null)
            return 0;
        
       
        
        Set<Integer> visited=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        visited.add(0);
        
        int jumps=0;
        
        while(!queue.isEmpty())
        {
            int size=queue.size();
            
            for(int j=0;j<size;j++)
            {
                
            int index=queue.poll();
            
             for(int i=1;i<=nums[index];i++)
             {
                 int newIndex=index+i;
                 
                 if(newIndex==nums.length-1)
                     return jumps+1;
                 if(!visited.contains(newIndex))
                 {
                     queue.add(newIndex);
                     visited.add(newIndex);
                 }
              }  
            }
            jumps++;
        }
        return jumps;
    }
}