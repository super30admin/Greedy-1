/*Time complexity : O(N)
Space Complexity : O(1)
Did it run on LeetCode? :Yes
Any problems? No
*/
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true; // if only 1 element.
        if(nums[0]==0) return false; //if first is 0. Can't jump.
        
        
        int lastnum = nums.length-1;
        for(int i=nums.length-2;i>=0;i-- ) // CHECK from Last element if we can reach that element from the previous elements.
        {
            if(i+nums[i]>=lastnum)
            {
             lastnum=i;
            }
        }
        
     if(lastnum==0) return true;
        else return false;
 }
}

