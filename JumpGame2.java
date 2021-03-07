// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes

class JumpGame2 {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;

        //initialize jumps, currInt, nextInt
        int jumps = 1;
        int currInt = nums[0], nextInt = nums[0];
        //iterate throught the nums array
        for(int i=0; i < nums.length; i++){
            //calculate the max index that can be reached from current index
            nextInt = Math.max(nextInt, nums[i] + i);
            //if currInt is equal to current index
            //if we have reached last index no need to calculate jump now
            if(i < nums.length -1 && currInt == i){
                //move currInt to nextInt & increment jump
                //means that this is the jump to be taken
                currInt = nextInt;
                jumps++;
            }
        }

        return jumps;
    }
}