import java.util.Scanner;

public class JumpGameMinGreedy {

        // Greedy - over intervals - Time O(n) and Space O(1)

        public int jump(int[] nums) {

            if(nums.length < 2) {
                return 0;
            }

            // current and next intervals as zeroth element value, and minimum jump initially is 1
            int currInt = nums[0];
            int nextInt = nums[0];
            int jump = 1;

            // iterate over nums
            for(int i = 0; i < nums.length; i++) {           // O(n)

                // next interval will be updated if current index + maximum allowed jump length there exceeds existing next interval
                nextInt = Math.max(nextInt, i + nums[i]);

                // if current interval end is reached
                if(i == currInt) {

                    // increment jumps required
                    jump++;

                    // next interval end becomes current interval end
                    currInt = nextInt;
                }

                // if last index of nums becomes the end of current interval, we are done
                if(currInt == nums.length - 1) {

                    break;
                }
            }
            // output
            return jump;
        }

        public static void main(String[] args) {

            JumpGameMinGreedy obj = new JumpGameMinGreedy();

            Scanner scanner = new Scanner(System.in);

            System.out.println("array length: ");
            int n = scanner.nextInt();

            int[] nums = new int[n];
            System.out.println("array: ");
            for(int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            int answer = obj.jump(nums);
            System.out.println("Minimum number of jumps required to reach the last index: " + answer);
        }

}

/*
TIME COMPLEXITY = O(n)
SPACE COMPLEXITY = O(1)
*/

