class Solution {
    //Time Complexity:O(n)
    //Space Complexity:O(n)
    public int candy(int[] ratings) {
        
        int sum = 0;
        int n = ratings.length;
        int[] candy = new int[ratings.length];
        Arrays.fill(candy,1);
        for (int i =1;i < ratings.length;i++){
          if (ratings[i] > ratings[i-1])
          candy[i] = Math.max (candy[i], 1 + candy[i-1]); 
        }
        sum = candy[n-1];
         for (int i = n- 2;i >=0;i--){
          if (ratings[i] > ratings[i+1])
          candy[i] = Math.max (candy[i], 1 + candy[i+1]); 
          sum += candy[i];
        }
        
        return sum;
    }
}
