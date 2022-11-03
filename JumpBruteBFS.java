class Solution {
    //tc-exponential n^k where k is no of steps at every indx
    public boolean canJump(int[] nums) {
        if(nums.length < 2) return true;
        int n = nums.length-1;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        while(!q.isEmpty())
        {
        int i = q.poll();       
        for(int j=1;j<=nums[i];j++)//(int j=nums[i];j>=1;j--) we cantake max jump 1st
        {
        int newidx = i+j;
        if(newidx >= n) return true;
        if(!set.contains(newidx))
        {
        q.add(newidx);
        set.add(newidx);
        }
        }
        }
        return false;
    }
}