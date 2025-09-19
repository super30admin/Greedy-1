// Time Complexity: O(n) — single pass over ratings with O(1) work per element.
// Space Complexity: O(1) — uses constant counters (up, down, slopes), no extra arrays.

// Traverse and compute slope per step (−1/0/+1); on a “turn” (up→non-up or down→non-down), flush candies for the previous run: count(up) + count(down) + max(up, down), then reset up & down.
// For each step: if increasing, up++; if decreasing, down++; if equal, candies++ (flat gets 1), and track oldSlope ← newSlope.
// After the loop, flush the last run with count(up)+count(down)+max(up,down) and return candies + 1 (the +1 accounts for the first child).

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int up = 0, down = 0;
        int oldSlope = 0, newSlope = 0;
        int candies = 0;

        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                newSlope = 1;
            }else if(ratings[i] < ratings[i-1]){
                newSlope = -1;
            }else{
                newSlope = 0;
            }

            if((oldSlope < 0 && newSlope >= 0) || (oldSlope > 0 && newSlope == 0)){
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }

            if(newSlope == 1){
                up++;
            }else if(newSlope == -1){
                down++;
            }else{
                candies++;
            }

            oldSlope = newSlope;
        }

        candies += count(up) + count(down) + Math.max(up, down);

        return candies + 1;
    }

    private int count(int n){
        return n * (n + 1) / 2;
    }
}
