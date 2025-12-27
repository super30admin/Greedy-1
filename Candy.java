// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We follow two pass greedy approach and consider the maximum value between left neighbor and right neighbor comparision value. In one pass, we check
// the current child's left neighbor rating and assign the value. We assign 1 if it's less else assign 1 + left neighbor's candies. In second pass from end of
// array, we check the current child's right neighbor rating. If current child's rating is bigger, we consider the maximum of current candies of that child and
// adding 1 to right neighbor's candies. We store these in arr, and iterate it to get the total candies.

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arr = new int[n];
        arr[0] = 1;
        int res = 0;
        for (int i = 1; i < n; i++) { // first pass to compare with left neighbor
            if (ratings[i] <= ratings[i - 1]) {
                arr[i] = 1; //assign the minimum
            } else {
                arr[i] = arr[i - 1] + 1; //add 1 to left neighbor value
            }
        }
        for (int i = n - 2; i >= 0; i--) { //second pass to compare with right neighbor
            if (ratings[i] > ratings[i + 1]) {
                arr[i] = Math.max(arr[i], arr[i + 1] + 1); //consider the max of left neighbor and right neighbor values
            }
        }

        for(int i : arr){
            res += i;
        }
        return res;
    }
}