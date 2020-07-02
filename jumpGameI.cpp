// Time Complexity : O(n)   
// Space Complexity : O(1)
// Did this code succesfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Key insight: value at left pointer should be greater than or equal to difference between left and right pointer indices

// 1. Maintain left pointer at second last element and right pointer at last element
// 2. Keep decreasing left pointer till element at left is not >= diff between left and right indices
// 3. If left goes below 0 while searching return false else make right as left and decrement left

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n=nums.size();
        if(n==0)
            return true;
        int left = n-2, right=n-1;
        while(right>0){
            while(left>=0 && nums[left]<right-left)
                left--;
            if(left<0)
                return false;
            right=left;
            left=right-1;
        }
        return true;
    }
};