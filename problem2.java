class jumpGameII {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        
        int jumps = 0;
        int curr = 0, next = 0;
        
        for(int i = 0; i < nums.length - 1; i++){
            next = Math.max(next, i + nums[i]);
            if(curr == i){
                jumps++;
                curr = next;
            }
        }
        return jumps;
    }
}
//time complexity O(n)
//space complexity O(1)