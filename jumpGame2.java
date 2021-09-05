// Time Complexity :  O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class jump2 {

    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) 
            return 0;

        int jumps = 1;
        int curr = nums[0];
        int next = nums[0];
        
        for(int i = 1; i < nums.length - 1; i ++){
            //either we keep current next or the new jump is landing to a higher index
            next = Math.max(next, nums[i] + i);

            //we reached the last highest index
            if(i == curr){
                jumps++;
                curr = next;
            }
        }
        
        return jumps;

    }

}