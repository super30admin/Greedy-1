import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

public class JumpGameBFS {

        // BFS - Time Exponential - Space O(n)

        public boolean canJump(int[] nums) {

            // if null nums or nums with a single element
            if (nums == null || nums.length < 2) {

                return true;
            }

            // queue of indices, add zeroth index initially
            Queue<Integer> q = new LinkedList<>();
            q.add(0);

            // hash set of visited indices to avoid duplicity in check
            HashSet<Integer> visited = new HashSet<>();

            // bfs run
            while (!q.isEmpty()) {

                // take head/ front index of queue
                int idx = q.poll();

                // makes allowed jumps at the polled index
                for (int j = 1; j <= nums[idx]; j++) {

                    // new index is sum of actual index plus allowed jump length
                    int newIdx = j + idx;

                    // if new index can go beyond last index of nums array, success
                    if (newIdx >= nums.length - 1) {

                        return true;
                    }

                    // only if new index is not already visited, add it both to queue and visited set
                    if (!visited.contains(newIdx)) {

                        q.add(newIdx);

                        visited.add(newIdx);
                    }

                }
            }

            // if the last index is not reach, failure
            return false;
        }

        public static void main(String[] args) {

            JumpGameBFS obj = new JumpGameBFS();

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
TIME COMPLEXITY = EXPONENTIAL
SPACE COMPLEXITY = O(n)
*/

