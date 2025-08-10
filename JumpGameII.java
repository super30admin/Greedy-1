import java.util.Arrays;
// Time Complexity :  O(N)
// Space Complexity : O(1)
public class JumpGameII {
    static int jump(int[] nums) {
        int n = nums.length;
        if(n < 2)return 0;
        int curr = nums[0];
        int steps = 1;
        int next = curr;

        for(int i = 1; i < n; i++){

            next = Math.max(next, nums[i] + i);
            if(i == curr) {
                curr = next;
                if(i != n-1) steps++;
            }
        }

        return steps;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println("Jump Array: " + Arrays.toString(nums));
        System.out.println("Minimum steps to reach end is: "+ jump(nums));
    }
}