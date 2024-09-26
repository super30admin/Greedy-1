// TC: O(n*n!) N! just because we are calculating all the values between the jump
// SC: O(1)

class Jump2 {
    public int jump(int[] nums) {
        // Returning 0 if array length is 0 or 1 or if array is null
        if(nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }
        int jump = 1;
        int curr = nums[0];
        int next = nums[0];
        for(int i=1; i<nums.length; i++){
            // Taking max of curr index + index value and prev next value
            next = Math.max(i + nums[i], next);            
            // if we having calculated all the values in between the jump changing the curr and increase the jump by 1
            if(curr == i && i != nums.length-1){
                jump += 1;
                curr = next;
            }
            // Check if current is greater than the array length if it is directly return jump
            if(curr >= nums.length-1)
                return jump;            
        }
        return -1;
    }
}