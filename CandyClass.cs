// TC => O(n)
// SC => O(n)

public class Solution {
    public int Candy(int[] ratings) {
        if(ratings == null || ratings.Length == 0){
            return 0;
        }
        int n = ratings.Length;
        int[] candies = new int[n];
        Array.Fill(candies, 1);

        for(int i = 1; i < n; i++){
            if(ratings[i -1] < ratings[i]){
                candies[i] = candies[i-1] + 1;
            }
        }

        for(int i = n-2; i>=0; i--){
            if(ratings[i] > ratings[i + 1]){
                candies[i] = Math.Max(candies[i], candies[i+1]+ 1);
            }
        }

        return candies.Sum();
    }
}