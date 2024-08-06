public class Candy {
    // Time complexity - o(n) + o(n) we ignore constant so o(n)
    // Space complexity - o(n) we used candies array to calculate candies for each kid.
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0){
            return 0;
        }
        int total =0;
        int[] candies = new int[ratings.length];
        int n = ratings.length;

        // Give one cady to each child as its the min.
        for(int i=0; i< n; i++){
            candies[i] =1;
        }

        //left to right check ratings and if greater increase by 1.
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }
        //right to left check  ratings and assign more candies if rating is higher Also calculate total
        total = candies[n-1];
        for(int i=n-2; i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i]= Math.max(candies[i], candies[i+1]+1);
            }
            total = total + candies[i];
        }
        return total;

    }
}
