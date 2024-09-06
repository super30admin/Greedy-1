//Time = O(n), length of input array
//Space = O(n)

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // initially assign 1 candy to each child
        
        // forward pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        
        // backward pass
        for (int i = n-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }
        
        // calculate total number of candies
        int totalCandies = 0;
        for (int i = 0; i < n; i++) {
            totalCandies += candies[i];
        }
        
        return totalCandies;
    }
}
