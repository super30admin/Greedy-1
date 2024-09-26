// TC: O(n)
// SC: O(1)
class Jump1 {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1)
            return true;
        int dest = nums[nums.length-1];
        // Move from right 
        // Destination is the last element and index is at dest index-1
        for(int i=nums.length-1; i>=0; i--){
            // If my currindex val + index exceeds the destination value then update destination index
            if(nums[i] + i >= dest)
                dest = i;
        }
        System.out.println(dest);
        // if my destination is 0 then we are sure that we can reach the required end destination
        if(dest == 0)
            return true;
        return false;
    }
}