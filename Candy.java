//Time-O(n)
//Space -O(1)
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int [] candies = new int[ratings.length];
        Arrays.fill(candies,1);
        for(int i =1; i< candies.length; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }
        int sum = candies[n-1];
        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
            sum+=candies[i];
        }
        
        return sum;
    }
}