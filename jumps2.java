class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int curr = nums[0];
        int next = nums[0];
        int jump = 1;
        
        for(int i = 1; i < nums.length - 1; i++){
            next = Math.max(next, i + nums[i]);
            if(i < nums.length - 1 && i == curr){
                curr = next;
                jump++;
            }
        }
        return jump;
        
    }
}
