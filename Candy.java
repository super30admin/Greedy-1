/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(2n)
    n - no of ratings
* 
* Space Complexity: O(n)
* 
*/
public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] candies = new int[n];

        for (int index = 0; index < n; index++) {
            candies[index]++;
        }

        // left pass
        for (int index = 1; index < n; index++) {
            if (ratings[index] > ratings[index - 1]) {
                candies[index] = Math.max(candies[index], candies[index - 1] + 1);
            }
        }

        // right pass
        for (int index = n - 2; index >= 0; index--) {
            if (ratings[index] > ratings[index + 1]) {
                candies[index] = Math.max(candies[index], candies[index + 1] + 1);
            }
        }

        int totalCandies = 0;

        for (int index = 0; index < n; index++) {
            totalCandies += candies[index];
        }

        return totalCandies;
    }
}
