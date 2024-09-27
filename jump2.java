/*
  Time: O(n)
  Space:O(1)
  Run on LeetCode: yes
*/
class Solution {
    public int jump(int[] nums) {
        if(nums.length < 2)
            return 0;

        int next = nums[0];
        int cur = nums[0];

        int jmp = 1;
        for(int i = 1; i < nums.length;i++){
            if(cur < i){
                jmp++;
                cur = next;
            }
            next = Math.max(nums[i]+i, next);
        }
        return jmp;
    }
}
