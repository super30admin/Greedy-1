//Time Complexity : O(n)
//Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public int jump(int[] nums) {
        if(nums==null || nums.length<2){
            return 0;
        }
        //keep track of the current element choosen for jumping
        int curInterval = nums[0];
        int nextInterval = nums[0];//keep track of the nextInterval to jump
        int jump = 1;//atleast one jump will definitely happen
        for(int i=1;i<nums.length;i++){
            nextInterval = Math.max(nextInterval,nums[i]+i);//nums[i]+i is making the jump to nextInterval from current element. Hence this is comparing the current jump with the next jump
            if(i==curInterval && i<nums.length-1){
                //if the end of the curInterval is reached increase the jump
                jump++;
                //update the new curInterval with rthe max jump found
                curInterval = nextInterval;
            }
        }
        return jump;
    }
}