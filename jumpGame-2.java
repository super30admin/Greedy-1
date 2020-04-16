#Time complexity:O(n)
# Space complexity: 0(1)
# Did code run successfully on leetcode: yes
# Any problem you faced: No






class Solution {
    public int jump(int[] nums) {

        int jumps = 0;
        int scope = 0;
        int farthest = 0;

        if(nums.length == 1) return 0;

        for(int i = 0 ; i < nums.length; i++){
            farthest = Math.max(farthest, i + nums[i]);

            if(farthest >= nums.length - 1) return jumps + 1;

            if(i == scope){
                jumps++;
                scope = farthest;
            }
        }

        return jumps;

    }
}