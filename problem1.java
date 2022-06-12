class jumpGame {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        
        int dest = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= dest){
                dest = i;
            }
        }
        
        return dest == 0;
    }
}
//time complexity O(n)
//space complexity O(1)