/*
Approach : Getting minimum jumps just by maximizing the next interval
*/
class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0; // [0,3] atleaset 1 jump
        
        int jumps = 1;
        int currInt = nums[0]; int nextInt = nums[0];
        for(int i = 1 ;i <nums.length;i++){
            nextInt = Math.max(nextInt,nums[i]+i);
            
            if(i < nums.length-1 && i == currInt){ //i mustnt be less than and equal to last number
              //if last number reached  ie i == nums.length then no more jumps needed 
              //so no increment on jumps  
                currInt = nextInt;
                jumps++;
            }
        }
        return jumps;         
    }
}

/*
Time complexity:O(n)
 Space complexity: O(1)   
 */