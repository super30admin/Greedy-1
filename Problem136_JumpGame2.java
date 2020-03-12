//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public int jump(int[] nums) {
        //edge case
        if(nums == null || nums.length < 2)
            return 0;
        int n = nums.length;
        //nextInterval and currentIntervals are tracked
        int nextInt = nums[0];
        int currInt = nums[0];
        //to keep track of the minimum jump needed to reach destination index
        int jump = 1;
        for(int i = 1; i< n; i++){
            //consider max of nextInterval and current calculated interval
            nextInt = Math.max(nextInt, i+nums[i]);
            //if reached i and currentInterval is equivalent to i
            //jump to closest destination found yet
            //let value of currentInterval be changed to nextInterval value
            if(i<n-1 && currInt == i){
                jump++;
                currInt = nextInt;
            }
        }
        //return all calculated jumps
        return jump;
    }
}