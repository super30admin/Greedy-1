//greedy comparing maxint and assigning values and increasing jumps once it reaches curreInt  jump

// O(n) time complexity
//o(1) space



class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        if(nums.length == 1){
            return 0;
        }

        int jumps = 1;
        int currInt = nums[0];
        int maxInt = nums[0];

        for(int i = 1; i <n; i++){

            maxInt = Math.max(maxInt, i+nums[i]);
        

            if(i != n-1 && i == currInt){
                jumps++;
                currInt = maxInt;

            }
                
            
            

        }
        return jumps;
        
        
        
    }
}
