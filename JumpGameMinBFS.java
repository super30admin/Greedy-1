import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Scanner;

public class JumpGameMinBFS {

        // BFS - Time Exponential - Space O(n)

        public int jump(int[] nums) {

            // if nums with a single element
            if(nums.length < 2) {

                return 0;
            }

            // queue of indices, add zeroth index initially
            Queue<Integer> q = new LinkedList<>();
            q.add(0);

            // hash set of visited indices to avoid duplicity in check
            HashSet<Integer> visited = new HashSet<>();
            visited.add(0);

            // minimum number of jumps possible initially
            int minJump = 1;

            // bfs run over levels
            while(!q.isEmpty()) {

                // size of a level
                int sizeQ = q.size();

                // iteration for a level
                for(int i = 0; i < sizeQ; i++) {

                    // to avoid null-pointer exception
                    if(!q.isEmpty()) {

                        // take head/ front index of queue
                        int idx = q.poll();

                        // makes allowed jumps at the polled index
                        for(int j = nums[idx]; j >= 1 ; j--) {

                            // new index is sum of actual index plus allowed jump length
                            int newIdx = j + idx;

                            // if new index can go beyond last index of nums array, output the minimum jump count
                            if (newIdx >= nums.length - 1) {

                                return minJump;
                            }

                            // only if new index is not already visited, add it both to queue and visited set
                            if (!visited.contains(newIdx)) {

                                q.add(newIdx);

                                visited.add(newIdx);
                            }
                        }
                    }
                }
                // minimum jump count increments after each level
                minJump++;
            }

            // we never reach here as reaching last index is guaranteed in test cases
            return 999;

        }

        public static void main(String[] args) {

            JumpGameMinBFS obj = new JumpGameMinBFS();

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
TIME COMPLEXITY = EXPONENTIAL
SPACE COMPLEXITY = O(n)

*/