class Solution {//Time and space of O(n)
    public int candy(int[] ratings) {
        //Base case 
        if(ratings == null || ratings.length == 0)
            return 0;
        int numChildren = ratings.length;
        
        if(numChildren == 1)
            return 1;
        int[] candies = new int[numChildren];
        Arrays.fill(candies,1);
        //Left side 
        for(int i = 1 ; i<numChildren ; i++){
            if(ratings[i]> ratings[i-1])
                candies[i] = candies[i-1] + 1;
        }
        //Right side 
        int sum = candies[numChildren-1];
        for(int j = numChildren-2 ; j>=0 ; j--){
            if(ratings[j]>ratings[j+1]){
                candies[j] = Math.max(candies[j+1]+1 , candies[j]);
            }
             sum += candies[j];        
        }
        return sum;
    }
}