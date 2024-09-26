//Time: O(N)

//calculate curInterval and Nextinterval and explore all the possible jumps for a particular index and pick the max 
// Increase jump with max jump if the index is eual to cur index position value

class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1 || nums.length == 0){
            return 0;
        }

        int jump = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            nextInterval = Math.max(i + nums[i], nextInterval);
            if(i == currInterval && i != nums.length - 1){ //edge case if jump of i > last elem
                jump += 1;
                currInterval = nextInterval;
            }
            
            if( currInterval >= nums.length){
                break;
            }
        }
        
        return jump;
    }
}
