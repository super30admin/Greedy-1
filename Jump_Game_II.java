/**************************************Using DFS********************************************/
// Time Complexity :O(n^n), as for n value we can make n jumps
// Space Complexity : O(n), as max n elements can be present in a stack during a recursive call
// Did this code successfully run on Leetcode : Time Limit Exceeded
// Any problem you faced while coding this : No

class Jump_Game_II_DFS {
	int minJumps;
	public int jump(int[] nums) {
		//edge
		if(nums == null || nums.length < 2)
			return 0;

		minJumps = Integer.MAX_VALUE;
		dfs(nums, 0, 0); //start from index 0 with 0 jumps so far
		return minJumps;
	}
	private void dfs(int[] nums, int index, int jumps) {
		//base
		if(index >= nums.length - 1)
		{
			//valid path to reach end
			minJumps = Math.min(minJumps, jumps);
			return;
		}
		//logic
		for(int i = 1; i <= nums[index]; i++)
		{
			//try all possibilities by increasing jump by 1
			dfs(nums, index + i, jumps + 1);
		}
	}
}

/*********************************Greedy Approach*************************************************/
// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Jump_Game_II_Greedy {
	public int jump(int[] nums) {
		if(nums == null || nums.length < 2)
			return 0;

		/***[2,3,1,1,4]
        Jumps       currInt         nextInt
            1       2               2
            1       2               Math.max(nextInt, nums[i] + i) => max(2, 4+1) =>5
            1       2               max(5, 1+2) = >5
            2       3               max(5, 4+1) => 5

		 ***/
		int jumps = 1;
		int currInt = nums[0];
		int nextInt = nums[0];
		for(int i=1; i<nums.length; i++){
			nextInt = Math.max(nextInt, nums[i] + i);
			if(currInt != nums.length-1 && currInt == i){
				currInt = nextInt;
				jumps++;
			}
		}
		return jumps;
	}
}
