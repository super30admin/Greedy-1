import java.util.Scanner;
import java.util.Arrays;

public class JumpGameDFS {

        // DFS - Time Exponential - Space O(n)

        int n;
        int[] visited;
        int[] nums;

        public boolean canJump(int[] nums) {

            this.nums = nums;
            n = nums.length ;

            // single element in nums
            if(n < 2) {
                return true;
            }

            visited = new int[n];

            // -1 -> not visited, 1 -> visited, 2 -> conclusively does not lead to the target
            // all elements are unvisited by default
            Arrays.fill(visited, -1);

            // run dfs from zeroth index
            return dfs(0);
        }


        public boolean dfs(int idx) {

            // if index conclusively leads to the target by surpassing the last index of nums, success
            if(idx >= n-1) {
                return true;
            }

            // if conclusively does not lead to the target, failure
            if(visited[idx] == 2) {
                return false;
            }

            // make it visited
            visited[idx] = 1;

            // allowed jumps from index depth wise
            for(int j = nums[idx]; j >= 1; j--) {

                // new index after jump
                int newIdx = j + idx;

                // if new index surpasses the last index of nums, success
                if(newIdx >= n-1) {
                    return true;
                }

                // if unvisited index and makes dfs true, success
                if(visited[newIdx] == -1 && dfs(newIdx)) {
                    return true;
                }

            }
            // after allowed jumps with no success, target is unreachable
            visited[idx] = 2;
            return false;
        }

        public static void main(String[] args) {

            JumpGameDFS obj = new JumpGameDFS();
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
TIME COMPLEXITY = Exponential

SPACE COMPLEXITY = O(n)

Recursive stack space = O(n)
visited array = O(n)
*/

