//Time Complexity : O(n)
//Space Complexity : O(1)
public class JumpGame_II {	
	/**Approach: Greedy**/
	 public int jump(int[] nums) {
	        int currInterval= nums[0];
	        int nextInterval= nums[0];        
	        if(nums==null || nums.length<2) return 0;
	        int jump=1;
	        for(int i=1; i<nums.length; i++){
	            nextInterval = Math.max(nextInterval, i+nums[i]);
	            if(i == currInterval && i!=nums.length-1){
	                jump++;
	                currInterval = nextInterval;
	            }
	            
	        }
	        return jump;
	    }
	
	// Driver code to test above
	public static void main (String[] args) {	
		JumpGame_II ob  = new JumpGame_II();		
		int[] nums = {2,3,1,1,4}; 
		System.out.println("Minimum number of jumps to reach the last index: "+ob.jump(nums));
	}
}
