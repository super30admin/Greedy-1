class Solution {
    //Idea is to use BFS to find the minimum jumps needed and hashset to avoid jumping from same index
    //Time Complexity: O(n^2)
    //Space Complexity: O(n)
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(0);
        int level = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int j=0;j<size;j++){
            int index = q.poll();

            for(int i=1;i<=nums[index];i++)
            {
                int newindex = index+i;
                if(newindex==nums.length-1) return level+1;
                if(!visited.contains(newindex)){
                    q.add(newindex);
                    visited.add(newindex);
                }
            }
            }
            
            level = level+1;
        }
        return -1;
    }
}