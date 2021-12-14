class Solution {
    public int candy(int[] ratings) {
        
        if(ratings == null || ratings.length == 0) return 0;
        int [] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        
        //left pass
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        // int sum = candies[candies.length-1];
        //right pass
        for(int i =ratings.length-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }
        int sum = 0;
        for(int ele: candies){
            sum += ele;
        }
        return sum;

    }
}

//TC: o(n)
//SC: o(n)
