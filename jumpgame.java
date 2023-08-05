// tc : O(n*n)
// sc : O(n)
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] checker = new boolean[n];
        checker[0] = true;
        for(int i = 0 ; i<n ; i++){
            if(!checker[i]) return false;
            for(int j = i ; j<=i+nums[i]; j++){
                if(j==n-1) return true;
                checker[j] = true;
            }
        }
        return true;
    }
}
