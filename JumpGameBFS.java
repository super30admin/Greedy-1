// Time Complexity : O(n ^ n)
// Space Complexity : O(n ^ n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Add the first element to the queue, then traverse over all possible jumps from that element and add it to the queue
//traverse the queue till it is empty, mark the visited elements(to avoid duplicates) and if the last element is visited, return true
class JumpGameBFS {
    public boolean canJump(int[] nums) {
        if(nums.length < 2) return true;

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(0);

        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int i = 1; i <= nums[curr]; i++) {
                int idx = curr + i;
                if(idx == nums.length-1) return true;
                if(!visited.contains(idx)) {
                    visited.add(idx);
                    q.add(idx);
                }
            }
        }
        return false;
    }
}
