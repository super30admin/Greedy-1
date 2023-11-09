//TC will be O(n)
//TC will be O(1)

class JumpGameII {
    public int jump(int[] nums) {
        if (nums==null || nums.length <2 ){
            return 0;
        }
        int n = nums.length;
        int jumps = 1;
        int currInterval = nums[0];
        int nextInterval = nums[0];

        for(int i = 0 ;i < n; i++){

            nextInterval = Math.max(nextInterval, i + nums[i]);

            if(i < n - 1 && i == currInterval){
                jumps++;
                currInterval = nextInterval;
            }

        }
        return jumps;
    }


    public static void main(String[] args){
        JumpGameII obj = new JumpGameII();
        int[] nums = {2,3,1,1,4};
        System.out.println(obj.jump(nums));

    }

}