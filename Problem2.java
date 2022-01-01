class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)
            return 0;
        int max = 0;
        int prevMax = nums[0];
        int steps = 1;
        for(int i=0;i<nums.length;i++){
            if(i > prevMax){
                steps++;
                prevMax = max;
                if(prevMax>=nums.length)
                    return steps;
            }
            max = Math.max(max, i+nums[i]);
        }
        return steps;
    }
}
