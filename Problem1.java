import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1 {
    // BFS solution
    // TC : O(n)
    // SC : O(n)
    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 1) return true;

        HashSet<Integer> visited = new HashSet<>();

        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        visited.add(0);
        while (!que.isEmpty()) {
            int size = que.size();
            int curr = que.poll();

            for (int i = 1; i <= nums[curr]; i++) {
                int idx = i + curr;

                if (idx == nums.length - 1) return true;

                if (!visited.contains(idx)) {
                    que.add(idx);
                    visited.add(idx);
                }
            }
        }
        return false;
    }

    // DFS solution
    // TC O(n)
    // SC O(n)
    HashSet<Integer> visited;
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 1) return true;

        visited = new HashSet<>();

        return dfs(nums, 0);
    }

    private boolean dfs (int[] nums, int curr){
        //base case
        if (visited.contains(curr)) return false;
        if (curr == nums.length -1) return true;


        //logic
        visited.add(curr);
        for (int i= 1 ; i <= nums[curr] ; i ++){
            int idx = i + curr;
            if (dfs (nums, idx)) return true;
        }
        return false;
    }

    // Optimal Solution
    // TC : O(n)
    // SC : O(n)
    public boolean canJump3(int[] nums) {
        if (nums == null || nums.length == 1) return true;

        int destination = nums.length -1;

        for (int i = nums.length-2; i >= 0 ; i-- ){
            int val = i + nums[i];
            if (val >= destination){
                destination = i;
            }
        }

        return destination == 0;
    }
}
