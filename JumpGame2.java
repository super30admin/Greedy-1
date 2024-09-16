package greedy1;

public class JumpGame2 {
	public static int jump(int[] nums) {
        int n = nums.length;
        
        if(n == 0 || n == 1) return 0;
        
        int jump = 1;
        // it is the initial position, and it is updated when index equals its value or if we reach last element
        int curpos = nums[0]; 
        // this is the max position where I can go and is updated according to the condition given below.
        int nextpos = nums[0];
        
        for(int i = 0; i < n; i++) {
            nextpos = (i + nums[i]) > nextpos ? (i + nums[i]) : nextpos;
            
            if(i == curpos && curpos != n - 1) {
                jump++;
                curpos = nextpos;
            }
            if(curpos >= n - 1) {
                break;
            }
        }
        return jump;
    }
	
	public static void main(String[] args ) {
		int[] nums = {2, 3, 1, 1, 4};
		System.out.println(jump(nums)); // 2
		
//		int[] nums1 = {2, 2, 1, 0, 4};
//		System.out.println(jump(nums1)); // 3
	}
}
