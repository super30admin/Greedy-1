Time Complexity (TC): O(n), where n is the length of the nums array, as we iterate through the array once.
Space Complexity (SC): O(1), as the solution uses only a constant amount of extra space.


class Solution {
    public int jump(int[] nums) {
        if(nums.length<2)return 0;
        int currInterval=nums[0];
        int nextInterval=nums[0];
        int jump=1;
        for(int i=0;i<nums.length;i++){
            nextInterval=Math.max(nextInterval,nums[i]+i);
            if(i==currInterval){
                if(i!=nums.length-1)jump++;
                currInterval=nextInterval;
            }
        }
        return jump;
    }
}