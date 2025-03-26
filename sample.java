// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int destination = nums.length-1;
        for (int i = n-2;i>=0;i--) {
            if (nums[i] + i >= destination){
                destination = i;
            }
        }
        if (destination == 0) {
            return true;
        }
        return false;
        
    }
}
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i=1;i<ratings.length;i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        int sum=candies[n-1];
        for (int i=n-2;i>=0;i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
            sum = sum + candies[i];
        }
        return sum;
    }
}


class Solution {
    public int jump(int[] nums) {
        int far=0;
        int jumps=0;
        int endofjumprange=0;
        if(nums.length == 1) {
            return 0;
        }
        for(int i=0;i<nums.length;i++) {
            far= Math.max(far, i+nums[i]);
            if(i == endofjumprange) {
                jumps++;
                endofjumprange = far;
            }
            if(endofjumprange == nums.length-1) {
                break;
            }
        }
        return jumps;
    }
}
