// TC => O(n)
// SC => O(n)

public class Solution {
    public int Jump(int[] nums) {
        if(nums == null || nums.Length <= 1){
            return 0;
        }

        int n = nums.Length, currInterval = nums[0], nextInterval = nums[0], jump = 1;
        for(int i = 0; i< n ;i++){
            nextInterval = Math.Max(nextInterval, i + nums[i]);
            if(i < n-1 && i == currInterval){
                currInterval = nextInterval;
                jump++;
            }
        }
        return jump;
    }
}