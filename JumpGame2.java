// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Initialize current and next interval to first element's interval
// Iterate through the array and for each index, find the  maximum next interval that can be reached
// If the current interval is ended, increment the jumps and update the current interval to next interval
// Do not increase the jumps if the current interval is not ended (curr interval can reach last index)

class Solution {

    public int jump(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return 0;
        int currInt = nums[0];
        int nextInt = nums[0];
        int jumps = 1;

        for (int i = 1; i < n; i++) {
            nextInt = Math.max(nextInt, i + nums[i]);
            if (i == currInt) {
                currInt = nextInt;
                if (i != n - 1)
                    jumps++;
            }
        }
        return jumps;
    }

    public int jumpBFS(int[] nums) {
        if (nums.length < 2)
            return 0;
        int jumps = 1;
        Deque<Integer> q = new LinkedList();
        HashSet<Integer> set = new HashSet();
        q.add(0);
        set.add(0);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int idx = q.poll();
                for (int i = 1; i <= nums[idx]; i++) {
                    int newIdx = i + idx;
                    if (newIdx >= nums.length - 1)
                        return jumps;
                    if (!set.contains(newIdx)) {
                        q.add(newIdx);
                        set.add(newIdx);
                    }
                }
            }
            jumps++;
        }
        return -1;
    }

    HashMap<Integer, Integer> memoMap;

    public int jumpDFS(int[] nums) {
        memoMap = new HashMap();
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int idx) {
        if (idx >= nums.length - 1)
            return 0;
        if (memoMap.containsKey(idx))
            return memoMap.get(idx);
        // logic
        int min = Integer.MAX_VALUE - 10;
        for (int i = 1; i <= nums[idx]; i++) {
            int newIdx = i + idx;
            min = Math.min(min, dfs(nums, newIdx));
        }
        memoMap.put(idx, min + 1);
        return min + 1;
    }
}