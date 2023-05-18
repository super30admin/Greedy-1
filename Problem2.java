// Time: O(n)
//  Spce: O(1)
class Solution {
    public int jump(int[] nums) {
        if(nums.length <2) return 0;
        int max = 0 ;
        int curFar = 0;
        int curEnd = 0;
        int jump =0 ;
        for(int i = 0 ; i< nums.length-1; i++){
            curFar = Math.max(curFar, i + nums[i]);
            if(i == curEnd){
                jump++;
                curEnd = curFar;
            }
        }
        return jump;
        
    }
}