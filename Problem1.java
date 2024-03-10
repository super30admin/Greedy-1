class Solution {
    //TC: O(n^2)
    //SC: O(n)
    public boolean canJump(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return true;
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        set.add(0);
        while(!q.isEmpty()){
            int currIdx = q.poll();
            for(int j = 1; j <= nums[currIdx]; j++){
                int newIdx = currIdx + j;
                if(newIdx == nums.length - 1) return true;
                if(!set.contains(newIdx)){
                    q.add(newIdx);
                    set.add(newIdx);
                }
            }
        }
        return false;
    }
}
