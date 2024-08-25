// Time Complexity : O(n)
// Space Complexity : O(n) as we are using an additional set and queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Faced TLE. Returned true on checking the jump which resolved TLE

/*
Approach: Using BFS. We will use a set to store the processed elements to avoid processing it again. Start by adding index 0 in both queue and set. Then check if queue is not empty, poll the element and run the for loop from 1 till the value at the polled index and calculate jump size. Check if jump size is not present in the set, add in both set and queue. Inside the loop we can check as soon as jump size == nums.length -1, we can return true.
 */
class Solution {
    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }

        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        set.add(0);

        while (!q.isEmpty()) {

            int curr = q.poll();

            for (int i = 1; i <= nums[curr]; i++) {
                int jump = curr + i;

                if (jump == nums.length - 1) {
                    return true;
                }
                if (!set.contains(jump)) {
                    q.add(jump);
                    set.add(jump);
                }
            }

        }

        return false;
    }
}