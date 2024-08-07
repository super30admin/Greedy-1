//TC - O(n)
//SC - O(n)
class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 1;
        }
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies,1);
        //do a left pass. Check left neighbour for every element
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }
        int total = candies[n - 1];
        //do a right pass. Check the right neighbour
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
            total = total + candies[i];
        }
       return total; 
    }
}
