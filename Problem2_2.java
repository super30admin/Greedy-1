//Time Complexity: O(n)
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem2_2 {

    public int jump(int[] nums)
    {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int jumps = Integer.MAX_VALUE;
        int lvl =0;
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int k =0; k < size; k++)
            {
                int curr = q.poll();

                for(int i =1; i <= nums[curr]; i++)
                {
                    int idx = curr + i;
                    if(idx == n-1)
                    {
                        jumps = Math.min(jumps,lvl +1);
                    }
                    if(idx <= n-1 && visited[idx] != true)
                    {
                        visited[idx] = true;
                        q.add(idx);
                    }
                }
            }
            lvl++;
        }
        
        if(jumps == Integer.MAX_VALUE)
            return 0;
        
        return jumps;
    }
}
