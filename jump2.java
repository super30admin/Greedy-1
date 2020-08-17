//TIme Complexity : O(n) n is the numberof elements in nums
//Space Complexity : O(1)
// LeetCode : passed all tests.


class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length <2) return 0;
        int jumps = 1;
        int currInt = nums[0];
        int nextInt = nums[0];
        for(int i = 1; i< nums.length-1;i++){
            nextInt = Math.max(i+nums[i],nextInt);
            if(i == currInt){
                currInt = nextInt;
                jumps++;
            }
        }
        return jumps;
    }
}