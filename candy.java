class Solution {
    public int candy(int[] ratings) {
      int n = ratings.length;
      int i = 1;
      int ans = 1; 

      while(i < n){
        //if flat slope 
        if(ratings[i] == ratings[i-1]){
          ans+=1;
          i++;
          continue;
        }
        //upward hill
        int peak = 1;
        while(i<n && ratings[i] > ratings[i-1]){
          peak++;
          ans+=peak;
          i++;
        }
        //downward hill
        int down = 1;
        while(i<n && ratings[i] < ratings[i-1] ){
          
          ans+=down;
          i++;
          down++;

        }
        //if downhill has more candies than peak give extra candy for peak
        if(down > peak){
          ans+=down-peak;
        }
      }
      return ans;
        
    }
}