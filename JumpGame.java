//Time complexity : O(n)
//Space complexity : O(1)
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        boolean canJump = canJump(nums);
        System.out.println(canJump);
    }

    private static boolean canJump(int[] nums) {
        if (nums.length < 2)
            return true;
        int target = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= target) {
                target = i;
            }
        }
        return target == 0;
    }

}
