class Solution {
    //TC: O(n)
    //SC: O(1)
    public int jump(int[] nums) {
        if(nums.length < 2) return 0;
        int currInt = nums[0];
        int nextInt = nums[0];
        int jumps = 1;
        for(int i = 0; i < nums.length; i++){
            nextInt = Math.max(nextInt, i + nums[i]);
            if( i == currInt && i != nums.length - 1){
                jumps++;
                currInt = nextInt;
            }
        }
        return jumps;
    }
}
