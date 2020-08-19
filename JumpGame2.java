//Time Complexity : O(n)
 //Space Complexity :O(1)   

// the main idea here is to check whether the index reach the last position by calculating the
//max positions and by having the maxSteps the cetains position can reach we get the minSteps.
class Solution {
    public int jump(int[] nums) {
        
        if(nums.length == 1 )
            return 0;
        int maxSteps = nums[0];
        int maxPosition = nums[0];
        int minJump=1;
        for(int i = 1 ; i < nums.length ;i++){
 
            
            //change maxSteps only when the currenst steps is not able to reach that step
            //and we have to jump
            if(maxSteps < i){
                maxSteps = maxPosition;
                minJump++;
            }
            maxPosition = Math.max(maxPosition,nums[i]+i);
        }
        
        return minJump;
    }
}