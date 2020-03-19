class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int jumps = 1; int currInt = nums[0]; int nextInt = nums[0];
        int n = nums.length;
        for(int i = 0; i < n; i++){
            nextInt = Math.max(nextInt, i+nums[i]);
            if(i < n-1 && i == currInt){
                currInt = nextInt; jumps++;
            }
        }
        return jumps;
    }
}