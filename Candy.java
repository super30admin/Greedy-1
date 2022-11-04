public class Candy {
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0) return 0;
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies,1);
        //left-pass
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1])
                candies[i] = candies[i-1]+1;
        }
        int sum = candies[n-1];
        
        //right-pass
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            sum+=candies[i];
        }
        return sum;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)
