//TC : O(N)
//SC : O(N)

class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        int[] answer = new int[n];
        
        Arrays.fill(answer, 1);
        
        //Left pass in O(N)
        for(int i = 1; i< n; i++){
            if(ratings[i] > ratings[i-1]){
                answer[i] = answer[i-1] + 1;
            }
        }
        
        //Right pass in O(N)
        
        int count = answer[n-1];
        for(int i = n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                answer[i] = Math.max(answer[i], answer[i+1] + 1);
            }
            count += answer[i];
        }
        
        
        return count;
    }
}