//Time-O(n)
//Space - O(1)
class Solution {
    public int jump(int[] nums) {
        int curr= nums[0];
        int next = nums[0];
        int n = nums.length;
        if(n<2) return 0;
        int jumps =1;
        
        for(int i=1; i< n ; i++){
            next = Math.max(next, i+ nums[i]);
            if(i!=n-1 && i == curr){
                curr = next;
                jumps++;
            }
        }
        return jumps;
    }
}