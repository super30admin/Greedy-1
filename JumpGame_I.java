// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class JumpGame_I {
	 public boolean canJump(int[] nums) {
	        int i=nums.length-1;
	        int j=i-1;
	        if(nums.length==1) return true;
	        while(j>0){
	            if(j+nums[j]>=i){
	                i=j;
	                j--;
	            }else{
	                j--;
	            }
	        }
	        if(j+nums[j]>=i){
	            return true;
	        }
	        return false;
	    }
}
