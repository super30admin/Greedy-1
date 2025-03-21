// SC:O(n)
// TC: O(n^k)


class Solution {
    public int jump(int[] nums) {
        int n= nums.length;
        if(n==1) return 0;
        
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(0); set.add(0);
        int level =0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int currIdx = q.poll();
                for(int j=1;j<=nums[currIdx];j++){
                    int child = currIdx+j;
                    if(child>=n-1) return level+1;
                    if(!set.contains(child)){
                         q.add(child); set.add(child);
                    }
                }
            }
            level++;
        }
        return level;
    }
}