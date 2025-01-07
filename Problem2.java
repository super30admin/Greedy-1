// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//TC:O(N)
//SC:O(1)
class Problem2 {
    public int jump(int[] nums) {
        return greedyHelper(nums);
    }

    //

    public int greedyHelper(int[] nums) {
        int n = nums.length;
        if (n==1) return 0;
        int nextInt = nums[0];
        int currInt = nums[0];//1
        int jumps =1;
        for(int i = 1 ;i<n;i++){
            nextInt = Math.max(nextInt, nums[i]+i);//1
            if(i<n-1 && i==currInt){
                // we have reached to the last index of the current so we go to the nextInt
                currInt = nextInt;
                jumps++;
            }


        }

        return jumps;
    }
}
