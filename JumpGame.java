//Time Complexity : O(n)
//Space Complexity : O(1)
public class JumpGame {	
	/**Approach: Greedy**/
	public boolean canJump(int[] nums) {
        int dest= nums.length-1;
        for(int i=nums.length-2; i>=0; i--){
            if(i+nums[i] >= dest){
                dest= i;
            }
        }
        return (dest == 0);
    }
	
	// Driver code to test above
	public static void main (String[] args) {	
		JumpGame ob  = new JumpGame();		
		int[] nums = {2,3,1,1,4}; //{3,2,1,0,4}
		System.out.println("Can you reach the last index? "+ob.canJump(nums));
	}
}
