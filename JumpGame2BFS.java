// Time Complexity : O(Exponential)
// Space Complexity : O(n)

class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2)
            return 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(0);
        visited.add(0);
        int jumps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i < size; i++){
                int idx = q.poll();
                for(int j = 1; j <= nums[idx]; j++){
                    int newIdx = idx + j;
                    if(newIdx <= nums.length - 1 && !visited.contains(newIdx)){
                        if(newIdx == nums.length - 1)
                            return jumps;
                        q.add(newIdx);
                        visited.add(newIdx);
                    }
                }
            }
            jumps++;
        }
        return jumps;
    }
}