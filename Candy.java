// Time Complexity : The time complexity is O(n) where n is the length of array
// Space Complexity : The space complexity is O(n) where n is the length of array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int candy(int[] ratings) {

        if(ratings == null || ratings.length == 0){
            return 0;
        }

        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies,1);

        // check with the left
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }

        // check with the right
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i],candies[i+1]+1);
            }
        }

        int sum = 0;
        for(int each:candies){
            sum += each;
        }

        return sum;

    }
}