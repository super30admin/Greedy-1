public class JumpGame {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            // System.out.println(target);
            if (i + nums[i] >= target) {
                target = i;
            }
        }
        return target == 0;
    }

    public static void main(String[] args) {
        JumpGame obj = new JumpGame();

        int[] nums1 = { 2, 3, 1, 1, 4 };
        System.out.println("Can we jump (nums1): " + obj.canJump(nums1));

        int[] nums2 = { 3, 2, 1, 0, 4 };
        System.out.println("Can jump (nums2): " + obj.canJump(nums2));
    }
}
