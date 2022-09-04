//Time Complexity: O(n)
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem1_2 {

    public boolean canJump(int[] nums)
    {
      
        int n = nums.length;
        boolean[] visited = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty())
        {
            int curr = q.poll();
        
            if(curr == n-1)
                return true;
            
            for(int i =1; i <= nums[curr]; i++)
            {
                if( curr + i <= n-1 && visited[curr + i] != true)
                {
                    visited[curr + i] = true;
                    q.add(curr + i);
                }
            }
        }
        return false;
    }
}
