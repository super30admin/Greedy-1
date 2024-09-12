import java.util.Scanner;

public class JumpGameGreedy {

        // Greedy - Time O(n) and Space O(1) - Shifting target from right (last index) to left (first index) locally

        public boolean canJump(int[] nums) {

            // begin from the main target i.e., the last index
            int target = nums.length - 1;

            // iterate from last but index towards left
            for(int i = nums.length - 2; i >= 0; i--) {      // O(n)

                // if current target can be reached from current index with maximum allowed jumps, shift target to current index
                if(nums[i] + i >= target) {

                    target = i;
                }

            }
            // if shifting target reaches the first index, success
            return target == 0;
        }

        public static void main(String[] args) {

            JumpGameGreedy obj = new JumpGameGreedy();
            Scanner scanner = new Scanner(System.in);

            System.out.println("array length: ");
            int n = scanner.nextInt();

            int[] nums = new int[n];
            System.out.println("array: ");
            for(int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            boolean answer = obj.canJump(nums);
            System.out.println("can the last index be reached? " + answer);
        }
}

/*
TIME COMPLEXITY = O(n)
SPACE COMPLEXITY = O(1)
*/
