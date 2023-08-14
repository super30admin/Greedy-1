public class JumpGameTwo {
    public int jump(int[] nums) {
        if (nums.length < 2)
            return 0;
        int nextInt = nums[0];
        int currInt = nums[0];
        int jumps = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            nextInt = Math.max(nextInt, i + nums[i]);
            if (i == currInt) {
                currInt = nextInt;
                jumps++;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGameTwo obj = new JumpGameTwo();

        int[] nums1 = { 2, 3, 1, 1, 4 };
        System.out.println("Minimum jumps (nums1): " + obj.jump(nums1));

        int[] nums2 = { 2, 3, 0, 1, 4 };
        System.out.println("Minimum jumps (nums2): " + obj.jump(nums2));
    }
}
