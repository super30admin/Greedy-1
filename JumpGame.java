class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(0); set.add(0);
        while(!q.isEmpty()){
            int idx = q.poll();
            for(int j = 1;j <= nums[idx]; j++){
                int newIdx = idx + j; 
                if(newIdx == n - 1) return true;
                if(!set.contains(newIdx)){
                    q.add(newIdx); set.add(newIdx);
                }
            }
        }
        return false;
    }
}