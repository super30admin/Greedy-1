// Time Complexity : O(2n) => O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: We make two passses through the array to allocate candies relative to the previous element
// 2: In the left pass, if the current element is greater than the previous element, we increment the candies by one
// 3: In the right pass, if the current element is greater than the rprevious element, we retain the max number of candies allocated to that index and add to the total
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);

        // left pass
        for(int i = 1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                arr[i] = arr[i-1] + 1;
            }
        }

        // right pass
        int total = arr[n-1];
        for(int i = n-2; i>=0;i-- ){
            if(ratings[i] > ratings[i+1]){
                arr[i] = Math.max(arr[i], arr[i+1] + 1);
            }
            total += arr[i];
        }
        return total;
    }
}