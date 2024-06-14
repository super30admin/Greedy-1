
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Time Complexity : O(k^N)
// Space Complexity : O(2N)
//Approach : BFS using Queue
class Solution {
    public boolean canJump(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        if(nums.length <=1) return true;
        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        set.add(0);

        while(!q.isEmpty()) {
            int currIdx = q.poll();
            for(int j=1;j<= nums[currIdx];j++){
                int newIdx = currIdx +j;
                if(newIdx >= nums.length-1){
                    return true;
                }
                if(!set.contains(newIdx)) {
                    q.add(newIdx);
                    set.add(newIdx);
                }
            }
        }

        return false;
    }
}

//DFS
// Time Complexity : O(k^N)
// Space Complexity : O(2N)
class Solution {
    HashSet<Integer> set = new HashSet<>();
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int i) {
        // base case
        if(i >= nums.length-1){
            return true;
        }
        if(set.contains(i)) return false;

        //logic
        for(int j =1;j<=nums[i];j++){
            int newIdx = i +j;
            if(dfs(nums, newIdx)) return true;
        }
        set.add(i);
        return false;
    }
}
//Greedy
//TC: O(N)
//SC: O(1)
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int target = n-1;

        for(int i=n-2;i>=0;i--){
            if(i+nums[i] >= target) {
                target = i;
            }
        }

        return target == 0;
    }
}