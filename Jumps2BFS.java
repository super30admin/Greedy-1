class Solution {
        //tc-exponential sc-o(n)
    public int jump(int[] nums) {
        if(nums.length < 2) return 0;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int jumps = 1;
        set.add(0);
        q.add(0);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int k=0;k<size;k++)
            {
                int i = q.poll();
                for(int j=1;j<=nums[i];j++)
                {
                 int newidx = i+j;
                 if(newidx == nums.length-1) return jumps;
                 if(!set.contains(newidx)) q.add(newidx); set.add(newidx);
                }
                
            }
            jumps++;
        } 
        return -1;
    }
}