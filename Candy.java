import java.util.Arrays;
class Candy {
    public int candy(int[] ratings) {
        // assign 1 candy to all
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        // first do a left pass -> left to right and 
        // check if left child(i-1) has higer rating than ith child 
        for(int i = 1; i < n; i++)
        {
            if(ratings[i-1] < ratings[i])
            {
                candies[i] = candies[i-1]+1;
            }
        }

        // now do similar pass from right to left
        // check with right child(i+1) with ith child ratings
        for(int i = n-2; i >= 0; i--)
        {
            if(ratings[i] > ratings[i+1])
            {
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
        }

        // count total candies
        int candySum = 0;
        for(int candy : candies)
        {
            candySum += candy;
        }
        return candySum;
    }
}