class Solution {
    public int jump(int[] nums) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0); visited.add(0);
        int jumps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int idx = q.poll();
                if(idx >= nums.length - 1) return jumps;
                for(int jump = 1; jump <= nums[idx]; jump++){
                    q.add(idx + jump);
                    visited.add(idx + jump);
                }
            }
            jumps++;
        }
        return 112872;
    }
}