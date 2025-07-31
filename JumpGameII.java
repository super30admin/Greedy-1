class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        HashSet<Integer> memoSet = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int jumps = 0;
        q.add(0);
        memoSet.add(0);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int currIdx = q.poll();
                if(currIdx == n - 1) return jumps;
                for(int j = 1; j <= nums[currIdx]; j++){
                    int newIdx = currIdx + j;
                    if(!memoSet.contains(newIdx)){
                        q.add(newIdx);
                        memoSet.add(newIdx);
                    }
                }
            }
            jumps++;
        }
        return jumps;
    }
}
