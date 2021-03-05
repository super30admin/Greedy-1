
/*//DFS - Approach
 * The Time complexity of the algorithm is O(2^n) where n is no of elements.
 * The Space complexity of the algorithm is O(1).
 */

/*//- Approach
 * The Time complexity of the algorithm is O(n) where n is no of elements.
 * The Space complexity of the algorithm is O(1).
 */

public class JumpGame {

	// dfs approach

//	 public boolean canJump(int[] nums) {
//	        
//	        if(nums.length <2)
//	            return true;
//	        
//	        return dfs(nums,0);        
//	        
//	    }
//	    
//	    
//	    private boolean dfs(int[] nums,int index){
//	        
//	        //base
//	        if(index >= nums.length-1)
//	            return true;
//	        
//	        //logic
//	        
//	        for(int j=1;j<=nums[index];j++){
//	            
//	            if(dfs(nums,j+index)) return true;
//	            
//	        }
//	        
//	        return false;
//	        
//	    }

//	

	public boolean canJump(int[] nums) {

		if (nums.length < 2)
			return true;

		int n = nums.length;
		int destination = n - 1;

		for (int i = n - 2; i >= 0; i--) {

			if (i + nums[i] >= destination)
				destination = i;

		}

		return destination == 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
