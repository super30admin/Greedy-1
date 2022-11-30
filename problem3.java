package Greedy-1;

public class problem3 {
    //TC:- O(n)
    //SC:- O(n)
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        
        int n = ratings.length;
        int total = 0;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        
        //left to right and checking left element
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                result[i] = result[i-1] + 1;
            }
        }
        
        //right to left and checking right element
        total = result[n-1];
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                result[i] = Math.max(result[i],result[i+1] + 1);            
            }
            total = total + result[i];
        }

        return total;
    }
}
