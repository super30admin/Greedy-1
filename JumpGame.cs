// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public bool CanJump(int[] nums) {
    //if there is no element or 1 element, return true, because we are already on last index
    if(nums == null || nums.Length < 2)
        return true;
    
    int n = nums.Length;
    int destination = n - 1;

    // 1) Start from end last index(destination)
	// 2) Start checking previous element + prev index >=  destiantion, if yes, set a new destination
	// 3) Keep going back until u reach first index

    for(int i = n-2; i >= 0; i--)
    {
        if(nums[i] + i >= destination)
            destination = i;
    }
    
    return destination == 0;
}