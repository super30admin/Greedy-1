// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Set destination to last index. Start iterating over input vector from right side, starting from second last element.
 * While iterating if current index + nums[index] is greater than or equal to destination then update destination to current index.
 * At the end if destination value is 0, return true.  
 */

class Solution {
public:
    bool canJump(vector<int>& nums) {
        if (nums.size() < 2)
        {
            return true;
        }
        
        int destination = nums.size() - 1;
        
        for (int i = nums.size() - 2; i >= 0; i--)
        {
            if (nums[i] + i >= destination)
            {
                destination = i;
            }
        }
        
        return destination == 0;
    }
};