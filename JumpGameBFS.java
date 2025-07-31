// TC: O(n^2)
// SC: O(n)
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<Integer>();
        Queue<Integer> bfs = new LinkedList<Integer>();

        bfs.add(0);
        set.add(0);

        while (!bfs.isEmpty()) {
            int currIdx = bfs.poll();

            for (int i = 0; i <= nums[currIdx]; i++) {

                if (currIdx + i == n - 1) {
                    return true;
                }
                if (set.contains(currIdx + i)) {
                    continue;
                }
                bfs.add(currIdx + i);
                set.add(currIdx + i);

            }
        }
        return false;
    }
}