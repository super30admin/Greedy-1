package Greedy-1;

public class problem2 {
    //TC:- O(n)
    //SC:- O(1)
    public int jump(int[] nums) {
        if(nums.length < 2) return 0;
        
        int jumps = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];
        int n = nums.length;
        
        for(int i = 1; i < n; i++){
            nextInterval = Math.max(nextInterval, i + nums[i]);
            if(i < n - 1 && i == currInterval){
                jumps++;
                currInterval = nextInterval;
                
            }
            if(currInterval > n - 1){
                return jumps;
            }
            
        }
        
        return jumps;
    }
}
