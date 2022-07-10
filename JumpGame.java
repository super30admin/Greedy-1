// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Greedy soln
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target = n-1;
        // checking the possibilies from the last before, to see if it can fulfil the next
        for(int i=n-2;i>=0;i--) {
            int idx = i+nums[i];
            if(idx >= target) target = i;
        }
        return target == 0;
    }
}

//DFS: Time: O(Exponential) | Space: O(Height of the tree)
class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean canJump(int[] nums) {
        return  helper(nums, 0);
    }
    // we keep exploring until we reach n-1 indx, also we don't visit the same index again
    private boolean helper(int[] nums, int pivot) {
        int idx = pivot+nums[pivot];
        if(idx >= nums.length -1) {
            return true;
        }
        set.add(pivot);
        for(int i=pivot+1;i<=idx;i++) {
            if(!set.contains(i) && helper(nums, i)) return true;
        }
        return false;
    }
}

// BFS | Time: O(Exponential) | Space: O(Width of the tree)
class Solution {
    public boolean canJump(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int curr = q.poll();
                int idx = curr+nums[curr];
                if(idx >= nums.length-1) return true;
                for(int j=curr+1;j<=idx;j++){
                    if(j+nums[j] >= nums.length-1) return true;
                    if(!set.contains(j)) {
                        q.add(j);
                        set.add(j);
                    }
                }
            }
        }
        return false;
    }
}