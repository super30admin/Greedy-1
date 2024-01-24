//DFS approach
// TC: O(K^n) = avg choice of jump at every index
// sc: O(n) : at max stack will only have n  idnex.

class Solution {
    int[] nums;
    int count, jump;
    Map<Integer, Integer> map;

    public int jump(int[] nums) {
        // base case
        int n = nums.length;
        this.nums = nums;
        this.map = new HashMap();

        if (nums.length <= 1)
            return 0;

        // Set<Integer> set = new HashSet<>(); //visited
        return dfs(0);
    }

    // to solve the time liit exceeded problem, we use HashMap to store the value.
    private int dfs(int idx) {
        // base case
        if (idx >= nums.length - 1)
            return 0; // when standing at last index, we have jump as 0. we dont jump outside.
        if (map.containsKey(idx))
            return map.get(idx); // if map has the index, just return the index.

        // logic

        int minjump = 9999; // for the current parent index

        for (int jump = 1; jump <= nums[idx]; jump++) {
            int newidx = jump + idx;
            if (newidx < nums.length) // if index is outof bound, no need to explore.
            {
                if (!map.containsKey(newidx)) {
                    map.put(newidx, dfs(newidx)); // store for child index
                }
                minjump = Math.min(minjump, map.get(newidx)); // update minjump from all the babies.
            }
        }
        // store for the parent index after for loop
        map.put(idx, minjump + 1);
        return minjump + 1;
    }
}

// BFS apporach
// TC: O(n) ; we''ll not have more than n index, as we keep track of set.
// sc: set9+ queue space: O(n)
class Solution {
    public int jump(int[] nums) {
        // base case
        int n = nums.length;
        if (nums.length <= 1)
            return 0;

        Set<Integer> set = new HashSet<>(); // visited

        Queue<Integer> q = new LinkedList<>();
        q.add(0); // adding index
        set.add(0); // visited

        int jump = 1;
        while (!q.isEmpty()) {
            int size = q.size(); // to define the level
            for (int i = 0; i < size; i++) {
                int curridx = q.poll(); // poll the idx

                for (int j = 1; j <= nums[curridx]; j++) // run loop for number of jumps
                {
                    int newidx = curridx + j;

                    if (newidx == n - 1)
                        return jump;

                    if (!set.contains(newidx) && nums[newidx] > 0) {
                        set.add(newidx);
                        q.add(newidx);
                    }
                }
            }
            jump++; // increment the level when we're done processing all the elements
        }
        return jump;
    }
}
