/*
TC: O(n)
SC: O(1)
*/
class Solution {
    public int jump(int[] nums) {
         
        if(nums == null || nums.length < 2)return 0;
        
        int currPos = nums[0];
        int nextPos = nums[0];
        
        int jumps = 1;
        for(int i = 1;i < nums.length ;i++){
            nextPos = Math.max(nextPos, i + nums[i]);
            
            if(i < nums.length-1 && currPos == i){
                jumps++;
                currPos = nextPos;
            }
        }
        
        return jumps;
    }
} 