//TC: O(n)
//SC:O(1)

class Solution {
    public int jump(int[] nums) {
        int jump=0; 
        int currInterval=0; 
        int max=0;
        
        for(int i=0; i<nums.length-1; i++)
        {
            max = Math.max(max, i+nums[i]);
            if(i == currInterval)
            {
                jump++;
                currInterval = max;
            }
        }
        return jump;
    }
}