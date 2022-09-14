// Time Complexity : O(n ^ n)
// Space Complexity : O(n ^ n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Add the first element to the queue, then traverse over all possible jumps from that element and add it to the queue
//traverse the queue till it is empty, mark the visited elements(to avoid duplicates) and if the last element is visited, return true
//Maintain the level to return the minimum number of jumps to reach the end point
class JumpGame2BFS {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        Set<Integer> visited = new HashSet<>();
        int jumps = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int curr = q.poll();
                for(int j = 1; j <= nums[curr]; j++) {
                    int newIdx = curr + j;
                    if(newIdx == n-1) return jumps + 1;
                    if(!visited.contains(newIdx)) {
                        visited.add(newIdx);
                        q.add(newIdx);
                    }
                }
            }
            jumps++;
        }
        return jumps;
    }
}