// TC: exponential
// SC: O(n)

class Solution {
    HashSet<Integer> visited;
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) {
            return true;
        }
        visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited.add(0);
        while(!q.isEmpty()) {
            int ind = q.poll();
            for(int j = 1; j <= nums[ind]; j++) {
                int newInd = ind + j;
                if(newInd == nums.length - 1) {
                    return true;
                }
                if(!visited.contains(newInd)) {
                    q.add(newInd);
                    visited.add(newInd);
                }
            }
        }
        return false;
    }
}