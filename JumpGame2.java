/*
 * TC: O(n)
 * SC: O(1)
 */
public class JumpGame2 {
    public int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            // update the max index we can reach
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                // if we are at the end, update number of jumps
                jumps++;
                // update the end to the max distance we can reach from here
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
