//  Time Complexity: O(n)
//  Space Complexity: O(1)

public class JumpGameII {
    public int jump(int[] nums) {

        int minJumps = 1;
        int curInterval = nums[0];
        int nextInterval = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            nextInterval = Math.max(nextInterval, i + nums[i]);

            if (curInterval >= nums.length - 1) {
                return minJumps;
            }

            if (curInterval == i) {
                minJumps++;
                curInterval = nextInterval;
            }
        }

        return 0;
    }
}
