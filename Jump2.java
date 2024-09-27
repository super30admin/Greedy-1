// Time Complexity : o(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n==0 || n==1) return 0;
        int jump=1;
        int currentPos = nums[0];
        int nextPos = nums[0];
        for(int i=1;i<n;i++){
            nextPos = i+nums[i]>nextPos ? i +nums[i] :nextPos;
            if(i==currentPos && currentPos !=n-1){
                jump++;
                currentPos = nextPos;
            }
            if(currentPos>=n-1){
                break;
            }
        }
        return jump;
        
    }
}