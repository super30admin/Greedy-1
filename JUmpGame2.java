class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int currInterval = nums[0];
        int nextInterval = nums[0];
        int jumps = 1;
        for(int i = 1 ; i < nums.length ; i++){
            nextInterval = Math.max(nextInterval , i+nums[i]);

            if(i == currInterval){
                currInterval = nextInterval;
                if(i!=nums.length-1){ //dont increment jump when u r at last index
                jumps+=1;
                }
            }
        }
        return jumps;
        
    }
}