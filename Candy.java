class Solution {
    public int candy(int[] ratings) {
        int total =0;
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int []result = new int[ratings.length];
        for(int i =0; i<ratings.length;i++) {
          result[i] = 1;
        }
        //left
        for(int i =1; i<ratings.length;i++) {
            if(ratings[i] > ratings[i-1]) {
                result[i] = result[i-1] + 1 ;
            }
        }
        
      for(int i =ratings.length-2; i>=0;i--) {
            if(ratings[i] > ratings[i+1]) {
                result[i] = Math.max(result[i], result[i+1]+1);
                
            }
        }
      for(int i =0; i<ratings.length;i++) {
        total = total+result[i];
      }
      return total;
    }
}