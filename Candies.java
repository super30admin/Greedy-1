// Time Complexity : O(2n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//2 pass solution
//Maintain a candies array
//Update the values in the left pass by comparing the ith element to its left neighbor
//Update the values in the rifht pass by comparing the ith element to its right neighbor, update the value to the max of its cur value and neighbor+1
//We do this in the right pass to avoid updating the element twice if it was updated in the left pass


class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;


        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        //Left pass
        for(int i = 1; i < n; i++) {
            if(ratings[i-1] < ratings[i]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        //Right pass
        for(int i = n-2; i >= 0; i--) {

            if(ratings[i+1] < ratings[i]) {
                candies[i] =  Math.max(candies[i], candies[i+1] + 1);
            }
        }

        int totalCandies = 0;
        for(int i = 0; i < n; i++) {
            totalCandies += candies[i];
        }


        return totalCandies;
    }

}
