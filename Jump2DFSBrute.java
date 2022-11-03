class Solution {
    //tc-exponential sc-o(1)   //we can optimize using memoizatiion by. taking -1,1,2
    int min;
    public int jump(int[] nums) {
        if(nums.length < 2) return 0;
        min = Integer.MAX_VALUE;
        dfs(nums,0,0);
        return min;
}
private void dfs(int[] nums, int idx, int jumps)
{
    //basecaase
    if(idx >= nums.length-1) 
    {
        min = Math.min(min,jumps);
        return;
    }

    //logic
    for(int i=1;i<=nums[idx];i++)
    {
      int newidx = i+idx;
      dfs(nums,newidx,jumps+1);
    }
}
}