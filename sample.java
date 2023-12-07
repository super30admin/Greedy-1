// ## Problem3 Candy (https://leetcode.com/problems/candy/)

// Time Complexity : O(m+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.


class Solution {
    public int candy(int[] ratings) {
        int[] result = new int[ratings.length];
        Arrays.fill(result, 1);
        int n = ratings.length;

        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                result[i] = result[i-1]+1;
            }
        }
        int min = result[n-1];
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                result[i] = Math.max(result[i], result[i+1] + 1);
            }
            min += result[i];
        }
        return min;
    }
}

// # Greedy-1

// ## Problem1 Jump Game (https://leetcode.com/problems/jump-game/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.


class Solution {
    public boolean canJump(int[] nums) {
        int lastPosition = nums.length - 1;
        for(int i = nums.length - 1; i >= 0 ; i--){
            if(i + nums[i] >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }
}

           
// ## Problem2 Jump Game II (https://leetcode.com/problems/jump-game-ii/)
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.


class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int jumps = 1;
        int curr = nums[0];
        int next = nums[0];
        for(int i=0; i<nums.length; i++){
            next = Math.max(next, i+nums[i]);
            if(i== curr && i!= n-1){
                jumps++;
                curr = next;
            }
        }
        return jumps;
    }
}