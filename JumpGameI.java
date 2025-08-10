// Time Complexity : O(N)
// Space Complexity : O(1)
public class JumpGameI {

    static boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        if(nums[0] == 0) return false;
        int target = n-1;
        for(int i = n-2; i>= 0; i--) {
            if(nums[i] + i >=  target) {
                target = i;
            }
        }
        return target == 0;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println("Will it reech end? -> " + canJump(nums) );
    }
}