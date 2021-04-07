//TC: O(n)+O(n)+O(n) which is nothing but O(n), n is number of elements in array
//SC: O(n)

//greedy algorithm


class Solution {
    public int candy(int[] ratings) {
        
        
        
        
        //traverse fromm left to right
        int[]candies = new int[ratings.length];
        Arrays.fill(candies,1);
        
        for(int i = 1; i < ratings.length;i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }
        
        //from right to left
        for(int i = ratings.length-2; i >= 0;i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
        }
        
        int count = 0;
        for(int c : candies){
            count += c;
        }
        return count;
    }
}

//1,1,1
//2,1,2
