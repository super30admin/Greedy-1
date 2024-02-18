//Time complexity : O(n)
//Space complexity : O(1)
public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        int minJump = jump(nums);
        System.out.println(minJump);
    }

    private static int jump(int[] nums) {
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

}
