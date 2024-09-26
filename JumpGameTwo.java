//Time Complexity: O(n)
//Space Complexity: O(1)

public class JumpGameTwo {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int n = nums.length;
        int nextInt = nums[0]; int currInt = nums[0]; int jumps = 1;
        for(int i = 1; i < n; i++){
            nextInt = Math.max(nextInt, i + nums[i]);
            if(i < n - 1 && currInt == i){
                jumps++; currInt = nextInt;
            }
        }
        return jumps;
    }
}
