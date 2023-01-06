// Time Complexity : O(n)
// Space Complexity :O(1)
class Solution {
    public int jump(int[] nums) {
        if(nums==null || nums.length==0 || nums.length<2) return 0;
        int jumps=1;
        int curr= nums[0], next= nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            next=Math.max(next, nums[i]+i);
            if(i<n-1 && i==curr){
                curr=next;
                jumps++;
            }
            
        }
        
        return jumps;
    }
}