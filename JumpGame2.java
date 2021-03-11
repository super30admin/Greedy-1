//Time Complexity: o(n)
//Space Complexity: o(1)
//Expln: Iterate through the array and keep max location we can reach in nextint and intitally the max location we can reach 
// first element. while iterating keep next max we can reach in nextint by calculating i+nums[i], when we reach the curr int
// that means we took a jump increment it and store the nextint which we compute in currint and keep doing this and keep calc again the next max
//we can reach. In this way if we reach the end element. return jump.
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len < 2) return true;
        int target = len -1;
        for(int i = len -2; i >=0; i--)
        {
            if(nums[i] + i >= target)
            {
                target = i;
            }
        }
        if(target == 0)
            return true;
        return false;
    }
}