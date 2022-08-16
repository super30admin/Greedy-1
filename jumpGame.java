
// approch 1
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 3
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

class Main {

    // approch 1 using greedy
    public static boolean canJump(int[] nums) {
        // null case
        if (nums == null || nums.length == 0)
            return true;
        int n = nums.length;
        // intiallially our target will be at the end
        int target = n - 1;
        // here I will check in for loop traversal
        // if I can get to target I will update the target as
        // we do not need to check from this point we can go to target
        // further
        if (nums[0] >= n - 1)
            return true;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= target) {
                target = i;
                // if target is at index 0 we do not need to check
                // further as we found out that we can go to 0->n-1
                // so return true
                if (i == 0)
                    return true;
            }
        }
        return false;
    }

    // approch 2 dfs with memorization
    private static int[] memo;

    public static boolean canJump2(int[] nums) {
        // null case
        if (nums == null || nums.length == 0)
            return true;
        // memo table
        // 0-> not visited
        // 1-> true
        // 2-> false
        memo = new int[nums.length];
        return helper2(0, nums);
    }

    public static boolean helper2(int idx, int[] nums) {
        // base case
        if (idx >= nums.length - 1)
            return true;
        // here
        if (memo[idx] != 0) {
            if (memo[idx] == 1)
                return true;
            else if (memo[idx] == 2)
                return false;
        }
        // main logic
        for (int i = nums[idx]; i > 0; i--) {

            // if we can get to last index we return true
            if (helper2(idx + i, nums)) {
                memo[idx] = 1;
                return true;
            }
        }
        memo[idx] = 2;
        return false;
    }

    // approch 3 BFS with hashSet
    public static boolean canJump3(int[] nums) {
        // null case
        if (nums == null || nums.length == 0)
            return true;
        if (nums.length == 1)
            return true;
        int n = nums.length;

        // hashset for already visited indexes
        HashSet<Integer> set = new HashSet<>();
        // queue for BFS traversal
        Queue<Integer> q = new LinkedList<>();
        // add index 0 in the q and add into hashset
        q.add(0);
        set.add(0);
        // BFS traversal
        while (!q.isEmpty()) {
            // get current index from the queue
            int curr = q.poll();
            // from current index +1 -> current index + nums[curr]
            // if index >= n-1 return true
            // else add index inside the queue and set
            for (int i = curr + 1; i <= curr + nums[curr]; i++) {
                if (i >= n - 1)
                    return true;
                // here I will also check if i is already inside the set
                // that means we already visited this index so we do not
                // need to add it inside the queue
                if (!set.contains(i)) {
                    q.add(i);
                    set.add(i);
                }

            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 3, 1, 1, 4 };
        System.out.println(canJump(nums));
        System.out.println(canJump2(nums));
        System.out.println(canJump3(nums));

    }
}