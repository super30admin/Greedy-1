class Solution {
    //Time Complexity:O(n)
    //Space Complexity:O(1)
    public int jump(int[] nums) {
        if (nums.length <=1)
        return 0;

            int n = nums.length;
         int currInteval = nums[0];
         int nextInterval = nums[0];
         int jumps =1;
         for (int i =0; i< n;i++){
            nextInterval = Math.max(nextInterval ,i+ nums[i]);
            if (i < n-1 &&i == currInteval ){
            jumps++;
            currInteval = nextInterval; 
                  }
              }
         return jumps;

    }
}
