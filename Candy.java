class Candy {

    // Time Complexity: O(n) -- O(3n)   (where n -> number of children)
    // Space Complexity: O(n)

    public int candy(int[] ratings) {
        int result = 0;
        // Edge Case Checking
        if(ratings == null || ratings.length == 0)
            return result;

        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        // left to right --> check if element to the left of curr position is smaller
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1]+1;
        }
        
        // right to left --> check if element to the right of curr position is smaller
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
        }
        
        // Calculate the total candies required
        for(int i : candies)
            result += i;
        
        return result;
    }
}