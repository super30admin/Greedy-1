//Timecomplexity:- O(n).
//space complexity :- O(1).
//Did it run on leetcode:- yes.
//Approach with code :- maintaining current interval, next interval where next interval will be updated when i +value at 
//that position and when i equals current interval current interval will be next interval. Like this when after iterating array
// jumps need to be returned.
class Solution {
    public int jump(int[] nums) {
        if(nums==null||nums.length<=1){
            return 0;
        }
        int jumps=1;
        int currentinterval=nums[0];
        int nextinterval=nums[0];
        for(int i=1;i<nums.length-1;i++){
            if(i+nums[i]>nextinterval){
                nextinterval=i+nums[i];
            }
            if(i==currentinterval){
                currentinterval=nextinterval;
                jumps++;
            }
            if(currentinterval>=nums.length-1){
                break;
            }
        }
        return jumps;
    }
}