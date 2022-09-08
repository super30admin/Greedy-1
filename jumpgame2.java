// TC: O(n)
// SC: O(1)

class Solution {
    public int jump(int[] nums) {
        if(nums.length<2) return 0;
        int n = nums.length;
        
        int currinterval=nums[0];
        int nextinterval=nums[0];
        int jump=1; // in one jump curr u can reach 2 and next is 2 
        
        for(int i=1;i<n;i++){
            nextinterval=Math.max(nextinterval,nums[i]+i);
            if(i<n-1 && i==currinterval){
                currinterval=nextinterval;
                jump++;
            }
        }
        
        return jump;
    }
}
