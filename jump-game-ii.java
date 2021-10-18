//Time Complexity: O(n)
//Space Complexity: O(1)
//running on leetcode: yes
class Solution {
    public int jump(int[] nums) {
       if(nums == null || nums.length < 2) return 0;
        int n = nums.length;
        int curr = nums[0];
        int farthest = nums[0];
        int jumps = 1;
        for(int i=0; i<n; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if(i < n - 1 && i == curr) {
                curr = farthest;
                jumps++;
            }
        }
        return jumps;
    }
}
