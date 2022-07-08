// Time Complexity :exponential
// Space Complexity :exponential as in queue, there can be large no of steps at each index
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    // BFS solution
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        HashSet<Integer> visited = new HashSet<>();
        int level = 1;
        while (!q.isEmpty()) {
            // take size varibale as we need no of jumps
            int size = q.size();
            // for each element at same level
            for (int s = 0; s < size; s++) {
                int i = q.poll();
                // we'l traverse through all the possibilities of jumps we can take
                for (int j = 1; j <= nums[i]; j++) {
                    int idx = i + j;
                    // when we reach at destination, we'l return the no of jumps ie levels
                    if (idx == nums.length - 1) {
                        return level;
                    }
                    if (!visited.contains(idx)) {
                        q.add(idx);
                        visited.add(idx);
                    }
                }

            }
            level++;
        }
        return 0;
    }
}

// -------------GREEDY---------------------------------------------------------
// Time Complexity :o(N)
// Space Complexity :CONSTANT
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// we have current interval and nextinterval, being in currInt we try to have
// maximum nextInterval
// whenever we cross current interval we increase jump by 1
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int currInt = nums[0];
        int nextInt = 0;
        int jump = 1;
        for (int i = 1; i < nums.length; i++) {
            nextInt = Math.max(nextInt, i + nums[i]);
            if (i != nums.length - 1 && i == currInt) {
                jump++;
                currInt = nextInt;
                nextInt = 0;
            }

        }
        return jump;
    }
}