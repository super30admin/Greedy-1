//Time Complexity:O(n)
//SPace Complexity:O(1)
//Approach- Iterate from the end and check if the sum of the current index and its value is greater than the last value, I'll update the last value to be equal to current index and continue to iterate. If the last value is 0, then I can jump from the start to end, other wise, I can not.
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        if(nums[0]==0){
            return false;
        }
        int last=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]+i>=last){
                last=i;
            }
        }
        return last==0;
    }
}