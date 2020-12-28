//time complexity:O(n)
//space complexity:O(1)

class Solution {
    int max;
    public int jump(int[] nums) {
        //edge
        if(nums==null || nums.length==1) return 0;
        int jump=1;
        int curr=nums[0];
        int next=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            next=Math.max(next,nums[i]+i);
            if(curr!=nums.length-1 &&i==curr)
            {
                jump++;
                curr=next;
            } 

        }
        return jump;
    }
}
