//Time complexity:O(n)
//SPace Complexity:O(1)
//Approach- Until curmax is reached, I'll keep updating the nextmax. When current max is reached, I'll increment jump and assign current max to be equal to the next max. AT the end I'll return jump value, which will have the min jumps.
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public int jump(int[] nums) {
        if(nums.length==1||nums.length==0){
            return 0;
        }
        int curmax=nums[0];
        int nextmax=nums[0];
        int jumps=1;
        for(int i=0;i<nums.length;i++){
            nextmax=Math.max(nextmax,nums[i]+i);
            if(i==curmax&&i!=nums.length-1){
                jumps++;
                curmax=nextmax;
            }
            if(curmax>=nums.length-1){
                break;
            }
            
        }
        return jumps;
        
    }
}
//Approach2: Greedy but with amortized O(N), but O(N^2) in worst case.
//Space Complexity:O(1)
//Here, I'll move in the direction of the maxval. Maxval is calculated by the sum of the element at the i+j th position + the value of j and the max index is the i+jth index. At the end of every j's iteration, I'll move to the index pointed by the maxindex. I'll continue until i+nums[i]<the length of the array -1. This approach helps in reaching the min jumps at a faster rate.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int count=0;
        int i=0;
        while(i+nums[i]<nums.length-1){
            int maxval=0;
            int maxidx=0;
            for(int j=1;j<=nums[i];j++){
                if(nums[i+j]+j>maxval){
                    maxval=nums[i+j]+j;
                    maxidx=i+j;
                }
            }
            i=maxidx;
            count++;
        }
        return count+1;
    }
}