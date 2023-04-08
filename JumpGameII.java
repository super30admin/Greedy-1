public class JumpGameII {
    //TC=O(n) SC=O(1)
    public int jump(int[] nums) {
        int n = nums.length;
        if(n<2) return 0;// make 0 jumps
        int currInt = nums[0];
        int nextInt = nums[1];
        int jumps = 1;
        for(int i=0;i<n;i++){
            nextInt = Math.max(nextInt,nums[i]+i);
            if(i==currInt && i!=n-1){
                jumps++;
                currInt = nextInt;
            }

        }

        return jumps;
    }
}
