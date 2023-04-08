public class JumpGame {
    //TC=O(n) SC=O(1)
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1)return true;
        int destination = n-1;
        for(int i=n-2;i>=0;i--){
            if(i+nums[i]>=destination){
                destination = i;
            }
            if(destination == 0){
                return true;
            }

        }
        return false;
    }
}
