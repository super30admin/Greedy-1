// Time Complexity : O(n)
// Space Complexity : O(1)
class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;

        int up = 0, down = 0;
        int oldSlope = 0, newSlope = 0;
        int sum = 0;
        int candies = 0;

        for(int i=1; i<n; i++) {
            if(ratings[i] > ratings[i-1]) {
                newSlope = 1;
            } else if(ratings[i] < ratings[i-1] ) {
                newSlope = -1;
            } else {
                newSlope = 0;
            }

            // identify transition 
            if(oldSlope < 0 && newSlope >= 0 || (oldSlope > 0 && newSlope == 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }

            if(newSlope == 1) {
                up++;
            } else if(newSlope == -1) {
                down++;
            } else {
                candies++;
            }

            oldSlope = newSlope;
        }

        candies += count(up) + count(down) + Math.max(up, down);

        
        return candies+1;
    }

    private int count (int n) {
        return n * (n+1)/2;
    }
}
