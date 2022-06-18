//time - O(n)
//space - O(1)
class Solution {
    public int jump(int[] nums) {
        if(nums==null || nums.length<2) return 0;
        int jumps = 1, curr = nums[0], next = nums[0];

        for(int i=0; i<nums.length; i++){
            if(i > curr){
                curr = next;
                jumps++;
            }
            if(i + nums[i] > next){
                next = nums[i]+i;
            }
        }

        return jumps;
    }
}
