// Time Complexity : O(nk)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/jump-game/
// Any problem you faced while coding this : No

class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length<2) return true;
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.add(0);
        set.add(0);
        while(!queue.isEmpty()){
            int idx = queue.poll();
            for(int j=1;j<=nums[idx];j++){
                int newIdx = idx+j;
                if(newIdx==nums.length-1) return true;
                if(!set.contains(newIdx)){
                    queue.add(newIdx);
                    set.add(newIdx);
                }
            }
        }
        return false;
    }
}
