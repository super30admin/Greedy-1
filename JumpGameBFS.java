// Time Complexity : O(Exponential)
// Space Complexity : O(n)

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length < 2)
            return true;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(0);
        visited.add(0);
        while(!q.isEmpty()){
            int idx = q.poll();
            for(int j = 1; j <= nums[idx]; j++){
                int newIdx = idx + j;
                if(newIdx <= nums.length - 1 && !visited.contains(newIdx)){
                    if(newIdx == nums.length - 1)
                        return true;
                    q.add(newIdx);
                    visited.add(newIdx);
                }
            }
        }
        return false;
    }
}