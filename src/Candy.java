// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {
    
    public int candy(int[] ratings) {
        
        int n = ratings.length;
        int[] candies = new int[n];

        Arrays.fill(candies, 1);

        for(int i=1; i<n; i++) {
            if(ratings[i] > ratings[i-1])                              // incrementing based on left
                candies[i] = candies[i-1]+1;
        }

        int res = candies[n-1];

        for(int i=n-2; i>=0; i--) {
            if(ratings[i] > ratings[i+1])                              // incrementing based on right if needed
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            res += candies[i];
        }

        return res;

    }

}
