import java.util.Scanner;
import java.util.HashMap;
public class JumpGameMinDFS {

        // DFS - Time - Exponential, Space O(n)
        HashMap<Integer, Integer> map;
        public int jump(int[] nums) {
            if(nums.length < 2) {
                return 0;
            }
            this.map = new HashMap<>();
            return dfs(nums, 0);
        }
        private int dfs(int[] nums, int idx) {
            if(idx >= nums.length - 1) {
                return 0;
            }
            int min = 9999;
            for(int j = nums[idx]; j >= 1; j--) {
                int newIdx = j + idx;
                if(!map.containsKey(newIdx)) {
                    int temp = 1 + dfs(nums, newIdx);
                    map.put(newIdx, temp);
                }
                min = Math.min(min, map.get(newIdx));
                map.put(idx, min);
            }
            // map.put(idx, min);
            return min;
        }

        public static void main(String[] args) {

            JumpGameMinDFS obj = new JumpGameMinDFS();

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
