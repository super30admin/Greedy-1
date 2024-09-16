
public class jumpGame2 {

	public int jumpGameII(int[] nums) {
		
		// check if the array is empty, if so, we return 0;
		if(nums == null || nums.length == 0)
			return 0;
		
		// we initialize the Farthest we can reach from currIndex, currIndex and how many jumps we take
		int currFarthest = 0, curEnd = 0, jumps = 0;
		
		for(int i=0;i<nums.length-1;i++) {
			
			// we take the max jump we can do from each index with the currMax and store it in currMaxFarthest value
			currFarthest = Math.max(currFarthest, nums[i]+i);
			
			// if the index is same as currEnd which we have reached, we can update our jump value and currEnd to our
			// max jump we took from our steps
			if(i == curEnd) {
				jumps++;
				curEnd = currFarthest;
			}
		}
		// return the jumps that we are updating.
		return jumps;
	}
}
