// TC:O(k^n)
// Sc:O(n)

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int idx = q.poll();
            if(idx==n-1) return true;
            for(int j=0;j<=nums[idx];j++){
                int newIdx = idx+j;
                if(newIdx==n-1) return true;
                if(!set.contains(newIdx)){
                    q.add(newIdx);
                    set.add(newIdx);
                }
            }
        }
        return false;
    }
}