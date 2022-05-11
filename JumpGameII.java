//Time Complexity O(N)
//Space Complexity O(1)
//Leetcode tested

import java.util.Arrays;

    public int jump(int[] nums) {
        int currInt = nums[0];
        int nextInt = nums[0];
        if(nums.length < 2) return 0;
        int jumps = 1;
        for(int i=1;i < nums.length-1;i++){
            nextInt = Math.max(nextInt,i + nums[i]);
            if(i == currInt){
                currInt = nextInt;
                jumps++;
            }
        }
        return jumps;
    }
}
