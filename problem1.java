package Greedy-1;

public class problem1 {
    //TC:- O(n)
    //SC:- O(1)
    public boolean canJump(int[] nums) {
        if(nums.length < 2) return true;
        
        int n = nums.length;
        int moves = nums[0];
        
        for(int i = 0; i < n; i++){
            moves = moves - 1;
            if(moves < 0) return false;
            if(moves >= n - 1) return true;
            moves = Math.max(moves,nums[i]);
        }
        
        return true;
    }
}
