// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes

class Candy {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        int n = ratings.length;

        //intiailize candies array and fill 1 representing atleast 1 candy for each rating
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        //pass from left to right and update candies of i if rating of i is greater than i-1
        for(int i = 1; i< n; i++){
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;
        }

        int sum = candies[n - 1];

        //pass from right to left and update candies of i if rating of i is greater than i+1
        for(int i = n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
            //add candies one by one to sum
            sum += candies[i];
        }

        return sum;
    }
}