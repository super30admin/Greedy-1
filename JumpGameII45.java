class Solution {
// Approach:
//     -For a taken jump, say jump1 is nums[0],  calc maximum jump 
//     possible within that jump length 
//     -And when that jump is completed, incrementing jump count
//     -If max jump length >= nums length ==> result
    
// Obs: Given, we will meet the destination always
//     ==> No zero in the first index 
//     ==> But [0] is possible ==> 0 jumps needed
    
// TC:  O(N)
// SC:  O(1)
    
    
    public int jump(int[] nums) {
        
        if(nums.length==0 || nums.length==1) return 0;
        
        int nextMax = nums[0];
        int currMax = nums[0];
        int jumps = 1;
        
        for(int i = 1; i < nums.length; i++){
            nextMax = Math.max( i + nums[i], nextMax);
            
            if( i == currMax && i != nums.length - 1){
                currMax = nextMax;
                jumps++;
            }
            
            if(currMax >= nums.length - 1)
                break;
        }
        return jumps;
    }
}