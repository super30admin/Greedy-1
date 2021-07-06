// Time, Space - O(N), O(N)

class Solution {
    public int candy(int[] ratings) {
        
        if(ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] candies = new int[ratings.length];        
        Arrays.fill(candies, 1);
        
        
        // left pass
        for(int i=1;i<ratings.length;i++) {
            if(ratings[i-1] < ratings[i]){
                
            candies[i] = candies[i-1] + 1;            
            }
        }
        
        for(int i=ratings.length - 2;i>=0;i--) {
                if(ratings[i+1] < ratings[i]) { 
                    candies[i] = Math.max(candies[i], 1 + candies[i+1]);     
            }
        }
        int result = 0;
        
        for(int i=0;i<candies.length;i++) {
            result += candies[i];
        }
        
        return result;
    }
}
