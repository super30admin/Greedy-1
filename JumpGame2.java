// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes


public class JumpGame2 {
    public int jump(int[] nums) {
       int res =0; int l=0; int r=0;

       while(r<nums.length-1){
           int far = 0;
           for(int i=l; i<=r; i++){
               far= Math.max(far, i+nums[i]);
           }
           l=r+1;
           r=far;
           res++;
       }
       return  res;
    }
}
