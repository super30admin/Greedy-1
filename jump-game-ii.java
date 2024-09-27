// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public int jump(int[] nums) {
        // edge
        if(nums == null || nums.length < 2) return 0;
        int nextInt = nums[0]; int currInt = nums[0]; int jumps = 1;
        int n = nums.length;
        for(int i = 1; i < n; i++){
            nextInt = Math.max(nextInt, i+nums[i]);
            if(i < n - 1 && currInt == i){
                System.out.println(i);
                jumps++; currInt = nextInt;
            }
        }
        return jumps;
    }
}