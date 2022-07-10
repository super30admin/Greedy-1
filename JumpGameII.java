// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Greedy soln
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        // we start from the first element
        int currMaxInterval = nums[0];
        int nextInterval = nums[0];
        int jumps = 1;
        for (int i = 1; i < n; i++) {
            if (currMaxInterval >= n - 1) return jumps;
            // we keep calculating the next farthest element possible from each index
            nextInterval = Math.max(nums[i] + i, nextInterval);
            // once we exhaust the current interval, we update it to the calculated nextInterval
            if (i == currMaxInterval) {
                currMaxInterval = nextInterval;
                jumps++;
            }
        }
        return 0;
    }
}

// BFS | Space: O(Width of the tree - at max Maximum element+index) | Time: O(Exponential)

class Solution {
    public int jump(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        if(nums.length > 1) {
            q.add(0);
            set.add(0);
        }
        int jump = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            // we keep exploring all the levels in a bfs manner
            // as soon as we encounter the last index, we return the number of levels happened until then
            for(int i=0;i<size;i++) {
                int curr = q.poll();
                int idx = curr+nums[curr];
                if(idx >= nums.length -1) return jump;
                for(int j=curr+1;j<=idx;j++){
                    if(!set.contains(j)) {
                        q.add(j);
                        set.add(j);
                    }
                }
            }
            jump++;
        }
        return 0;
    }
}