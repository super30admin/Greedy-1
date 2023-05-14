/**
Time Complexity - O(n)
Space Complexity - O(1)
Approach - 
Base idea - Distribution of candies for a strictly increasing or strictly decreasing input of length n would be SUM of numbers from 1 to n.

Find the number of elements in increasing/ decreasing order in segments in the input.
1. calculate slope.
2. if it is an increasing slope, increment the no of elements in increasing array by 1.
3. if it is a decreasing slope, increment the no. of elements in decreasing array by 1.
4. if slope is zero, simply increase the output by 1.
5. when we reach the end of the mountain (mountain end is identified by oldSlope < 0. here the next segment could be a plateau or a mountain.) or when a rising slope is followed by a plateau.
calculate the total candies for the mountain using the below formula
            sum_of_n (up) + sum_of_n (down) + math.max(up, down) + 1 - 1.
    We are subtracting 1 here because the valley will be included in the next mountain that follows it.  
 */
public class Solution {
    public int count(int n) {
        return (n * (n + 1)) / 2;
    }
    public int candy(int[] ratings) 
    {
        if (ratings.length <= 1) 
            return ratings.length;
        int candies = 0, up = 0, down = 0, oldSlope = 0;

        for (int i = 1; i < ratings.length; i++) {
            int newSlope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);
            if ((oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (newSlope > 0)
                up++;
            else if (newSlope < 0)
                down++;
            else
                candies++;

            oldSlope = newSlope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }
}
