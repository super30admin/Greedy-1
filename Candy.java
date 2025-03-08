//TC: O(n)
//SC: O(n)
//approach: two iterations from left to right and right to left to do left and right comparisons one by one

import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {
        int[] result = new int[ratings.length];
        if(ratings.length==1) return 1;
        Arrays.fill(result, 1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1] ){
                result[i] = result[i-1]+1;
            }
        }
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1] ){
                result[i] = Math.max(result[i],result[i+1]+1);
            }
        }
        int total =0;
        for(int i=0;i<ratings.length;i++){
            System.out.println(result[i]);
            total+=result[i];
        }
        return total;
    }
}
