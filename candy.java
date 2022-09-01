//Time Complexity: O(n).
//Space Complexity: O(n).

class Solution {
    public int candy(int[] ratings) {
        
    if(ratings.length == 0) return 0;
    int maxCandy = 0;
    int[] candyArray = new int[ratings.length];
     Arrays.fill(candyArray, 1);   
        
    for(int i = 1; i < ratings.length; i++){
        if(ratings[i] > ratings[i-1]){
            candyArray[i] = candyArray[i-1] + 1;
        }
    }
        
    for(int i = ratings.length-2; i >= 0; i--){
        if(ratings[i] > ratings[i+1]){
            int add = candyArray[i+1] + 1;
            if(candyArray[i] < add){
                candyArray[i] = add;
            }  
        }
     }  
        
    for(int i = 0; i < candyArray.length; i++){
        maxCandy = maxCandy + candyArray[i];
      } 
    return maxCandy;
    }
}