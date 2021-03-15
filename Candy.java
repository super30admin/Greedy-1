//Greedy
//TC: O(4N)
//SC: O(N)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int [] candies = new int[ratings.length];
        
        // give 1 candy to every child in the beginning
        Arrays.fill(candies, 1);
        
         //left pass -> if the current child's rating is higher than its left neigbor, 
        // then current child's rating =  left neigbor's rating + 1;
        for ( int i = 1; i < candies.length; i++ )
        {
            if (ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;
        }
        //right pass -> if the current child's rating is higher than its right neigbor, 
        // then current child's rating = 
       for ( int i = candies.length-2; i >= 0; i-- )
        {
            if (ratings[i] > ratings[i+1])
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
        }
        int sum = 0;
        for ( int i = 0; i < candies.length; i++ )
        {
            sum += candies[i];
        }
        return sum;
    }
}


    
