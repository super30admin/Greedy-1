//Time complexity : O(n)
//Space Complexity : O(n)
//Did it run on leetcode : yes

import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {

        int[] candies = new int[ratings.length];
        int n = ratings.length;

        Arrays.fill(candies, 1); // give 1 candy to everyone

        //left pass
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i - 1] + 1; //give 1 candy more than the neighbour
            }
        }

        int sum = candies[n-1];
        //right
        for(int i = n-2; i >=0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i + 1] + 1); //give 1 candy more than the                                                                                neighbour
            }
            sum+= candies[i];
        }
        return sum;
    }
}
