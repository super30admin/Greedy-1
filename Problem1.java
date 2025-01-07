// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//TC:O(N)
class Problem1 {
    //[2,3,1,1,4]
    public boolean canJump(int[] nums) {
        int reachableIndex = nums.length-1;
        for(int i = nums.length-2;i>=0;i--){
            if(canReach(i,reachableIndex,nums)){
                reachableIndex = i;
            }
        }
        if(reachableIndex==0){
            return true;
        }else{
            return false;
        }

    }


    public boolean canReach(int index,int toIndex,int[] nums){
        int maxJump = nums[index];
        if(index+maxJump<toIndex){
            return false;
        }else {
            return true;
        }
    }
}

