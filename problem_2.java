//Time-O(n)
//Space-O(1)
//Couldnt solve it so followed class approach
class Solution {
    public int jump(int[] nums) {
        if(nums==null || nums.length<=1)
        {
            return 0;
        }
        int cI=nums[0];
        int nI=nums[0];
        int jumps=1;
        for(int i=0;i<nums.length;i++)
        {
            nI=Math.max(nI,i+nums[i]);
            if(i==cI && i!=nums.length-1)
            {
                cI=nI;
                jumps++;
            }
            
        }
        return jumps;
    }
}
