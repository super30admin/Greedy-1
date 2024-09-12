//Time Complexity-O(n)
//Space Complexity-O(1)
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==0||
          nums==null)
        {
            return true;
        }
        int dest=nums.length-1;
        int i=nums.length-2;
        while(i>=0)
        {
            int index=i+nums[i];
            if(index>=dest)
            {
                dest=i;
            }
            i--;
        }
        return dest==0;
        
    }
}