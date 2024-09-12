//Time Complexity-O(n)
//Space Complexity-O(1)
class Solution {
    public int jump(int[] nums) {
        if(nums.length==0||
          nums==null||
          nums.length==1)
        {
            return 0;
        }
        int cur=nums[0];
        int next=nums[0];
        int jump=1;
        for(int i=1;i<nums.length;i++)
        {
            next=Math.max(next,i+nums[i]);
            if(i==cur && i!=nums.length-1)
            {
                cur=next;
                jump++;
            }
            if(cur>=nums.length-1)
            {
                break;
            }
        }
        return jump;
    }
}