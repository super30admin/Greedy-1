// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : Greedy

class Solution {
    public int candy(int[] ratings) {
        
        int length = ratings.length;

        int[] result = new int[length];

        // By default every child will get a candy
        Arrays.fill(result, 1);

        // Do a left to right pass and in each pass check for left neighbour rating
        for(int i = 1; i < length; i++)
        {
            if(ratings[i] > ratings[i - 1]) result[i] = result[i - 1] + 1;
        }


        int total = 0;

        // Do a right to left pass and in each pass check for right neighbour rating
        // We will also add all the candies in the same loop
        for(int i = length - 2; i >= 0; i--)
        {
            // In this case consider the maximum value betweenn existing rating and (1 + right neighbour candy) value
            if(ratings[i] > ratings[i + 1]) result[i] = Math.max(result[i], result[i + 1] + 1);

            // Keep count of all the candies
            total += result[i];
        }

        // As we started our loop from n - 2 we never added the candy count of length - 1 in our total
        total += result[length - 1];

        return total;
    }
}