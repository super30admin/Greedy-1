package Greedy-1;
// TC: O(n)
// SC: O(1)
public class Problem2 {
    public int jump(int[] nums) {
        int n=nums.length;
        if(n<=1) return 0;
        int jump=1;
        int currInt=nums[0];
        int maxInt=nums[0];
        for(int i=1;i<n-1;i++){
            //logic
            maxInt = Math.max(maxInt, nums[i]+i);
            if(currInt==i && currInt<n-1){
                jump++;
                currInt=maxInt;
            }
        }

        return jump; 
    }
}
