class Solution {//Time of O(n) and space of O(1)
    public int jump(int[] nums) {
        //Base case
        if(nums== null || nums.length<2)
            return 0;
        
        int n = nums.length;
        int maxNextInterval = nums[0];
        int currentInterval = nums[0];
        
        int jumps = 1;
        for(int i=1 ; i<n ; i++){
            //if you reach a point where your currentInterval is exhausted
            if(i>currentInterval){
                jumps +=1;
                currentInterval = maxNextInterval;
                
            }
            if(currentInterval>=n){
                break;
            }
            maxNextInterval = Math.max(maxNextInterval , nums[i]+i);
        }
        return jumps;
    }
}