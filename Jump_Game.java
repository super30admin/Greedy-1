/**************************************Using DFS********************************************/
// Time Complexity :O(n^n), as for n value we can make n jumps
// Space Complexity : O(n), as max n elements can be present in a stack during a recursive call
// Did this code successfully run on Leetcode : Time Limit Exceeded
// Any problem you faced while coding this : No

class Jump_Game_DFS {
	public boolean canJump(int[] nums) {
		if(nums == null || nums.length < 2)
			return true;

		return dfs(nums, 0);
	}
	private boolean dfs(int[] nums, int index){
		//base
		if(index == nums.length -1)
			return true;
		//logic
		for(int j=1; j<=nums[index]; j++){
			if(dfs(nums, index + j))
				return true;
		}
		return false;
	}
}

/*********************************Greedy Approach*************************************************/
//Time Complexity :O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Time Limit Exceeded
//Any problem you faced while coding this : No

class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2)
            return true;
        // nums = [2,3,1,1,4]							nums = [3,2,1,0,4]
        //destination = 4								//destination = 4
        //i=nums.length-2 => 3							//i=nums.length-2 => 3
        //if(3 + 1 >= 4)								//if(3 + 0 >= 4)
        // new destination = 3							//destination remains same = 4
        
        //i=nums.length-2 => 2							//i=nums.length-2 => 2
        //if(2 + 1 >= 3)								//if(2 + 1 >= 4)
        // new destination = 2							//destination remains same = 4
        
        //i=nums.length-2 => 1							//i=nums.length-2 => 1
        //if(1 + 3 >= 2)								//if(1 + 2 >= 4)
        // new destination = 1							//destination remains same = 4
        
        //i=nums.length-2 => 0							//i=nums.length-2 => 0
        //if(0 + 2 >= 1)								//if(0 + 3 >= 4)
        // new destination = 0							//destination remains same = 4
        
        // if destination == 0 return true;				// destination != 0, hence return false;
        
        int destination = nums.length -1;
        for(int i=nums.length-2 ; i>=0; i--){
            if(i + nums[i] >= destination){
                destination = i;
            }
        }
        return destination == 0;
    }
}
