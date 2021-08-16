class Canjump2 {
    //time: O(n)
    //space: O(1)
    public int jump(int[] nums) {
        //if input is empty or has just one element we don't jump
        if(nums==null || nums.length <2) return 0;
        //initializing current and next value of interval
        int curr = nums[0], next = nums[0];
        //initializing  umsp to one since current is already at index 0
        int jumps = 1;
        //looping the inout array
        for(int i=1; i<nums.length; i++){
            //update next
            next = Math.max(next, i+nums[i]);
            //if we have lopped till the current interval
            if(i<nums.length-1 && curr==i){
                //update current interval
                curr = next;
                //increemnt jump
                jumps++;
            }
        }
        return jumps;
    }
}