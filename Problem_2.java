// Time complexity - O(n)
// Space complexity - O(1)

class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length  < 2) return 0;
        int jumps = 1;
        int currInt = nums[0];
        int nextInt = nums[0];
        for(int i = 1; i < nums.length; i++){
            nextInt= Math.max(nextInt, i+ nums[i]);
            if( i < nums.length - 1 && i == currInt){
                currInt = nextInt;
                jumps++;
            }
        }
        return jumps;
    }
}
