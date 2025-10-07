class Solution {
    //Idea is to use BFS to find whether we can reach the end or not
    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public boolean canJump(int[] nums) {
       Queue<Integer> q = new LinkedList<>();
       HashSet<Integer> hs = new HashSet<Integer>();
       q.add(0);
       hs.add(0);
       while(!q.isEmpty())
       {  
            int index = q.poll();
            for(int i=index;i<=index+nums[index];i++)
            {
                if(i==nums.length-1)
                    return true;
                if(!hs.contains(i)){
                    q.add(i);
                    hs.add(i);
                }
            }
            
       }
       return false;
    }
}