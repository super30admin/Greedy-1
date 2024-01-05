// Time Complexity:  O(n)
// Space Complexity: O(1)

class Solution {
    
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        if(n==1) return true;
    
        int ind = n-1;                       // set last index
        int val = nums[ind];                 // set last value

        for(int i=ind-1; i>=0; i--) {
            if(i+nums[i] >= ind) {           // whenever (i+nums[i]) >= index
                ind = i;                     // change index
                val = nums[i];               // change value
            }
        }

        return ind==0;                       // if you reached index 0, then true

    }

}
