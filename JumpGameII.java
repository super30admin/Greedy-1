public class JumpGameII {
    //greedy - o(n)
    public int jump(int[] nums){
        int n = nums.length;
        if(n == 1) return 0;
        int currInt = nums[0];
        int nextInt = nums[0];
        int jumps = 1;

        for(int i = 1; i < n; i++){
            nextInt = Math.max(nextInt, nums[i]+i);
            if(i != n-1 && i == currInt){
                currInt = nextInt;
                jumps++;
            }

            if(currInt >= n-1) return jumps;
        }
        return -1;

    }
}
