// 55.
class Solution {
    public boolean canJump(int[] nums) {
        //edge
        if(nums == null || nums.length < 2)
        {
            return true;
        }
        //return dfs(nums, 0); //start from index 0
        return canJumpGreedy(nums);
    }
    
    //time - exponential - O(max number in nums[] ^ length of nums[])
    //space - O(length of nums[])
    private boolean dfs(int[] nums, int index) {
        //base
        if(index >= nums.length - 1)
        {
            //reaches(or crosses) end
            return true;
        }
        //logic
        for(int i = 1; i <= nums[index]; i++)
        {
            //at the given index, a jump of magnitude 1 to value in that index can be made
            //try all possiblities
            if(dfs(nums, index + i))
            {
                return true;
            }
        }
        return false;
    }
    
    //time - O(n)
    //space - O(1)
    private boolean canJumpGreedy(int[] nums) {
        int destination = nums.length - 1; //have to reach last index
        for(int i = nums.length - 2; i >= 0; i--)
        {
            //try to reach current dest from i
            if(i + nums[i] >= destination)
            {
                //dest reachable from i - so update dest to i
                destination = i;
            }
            if(destination == 0) //reached 0
            {
                return true;
            }
        }
        return false; //never reached 0
    }
}
