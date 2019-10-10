/*Time complexity : O(N)
Space Complexity : O(1)
Did it run on LeetCode? :Yes
Any problems? No
*/
class Solution {
    public int jump(int[] nums) {
        if(nums.length==0 || nums.length==1) return 0; // If just 1 element, minimum jump is 0.
        
        
        int current = nums[0]; // Create 3 variables to store current max , next max and number of jumps.
        int next = nums[0];
        int jump=1;
        
        for(int i=0;i<nums.length-1;i++)
        {
            if(i+nums[i]>next)
            {
                next=i+nums[i];
            }
            
            if(current==i &&i!=nums.length) // If current max  reaches the ith element.
            {
                current=next;
                jump++;
            }
            if(current>=nums.length) break;
        }
        
        return jump;
    }
}
