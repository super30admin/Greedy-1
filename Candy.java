import java.util.Arrays;

//TC will be O(n)
//SC will be O(n)
class Candy {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0){
            return 0;
        }

        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for(int i =1 ; i<n; i++){
            if(ratings[i] > ratings[i -1]){
                candies[i] = candies[i -1] + 1;
            }
        }

        int total = candies[n -1];
        for(int i = n -2 ; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            total = total + candies[i];
        }
        return total;
    }

    public static void main(String[] args){
        Candy obj = new Candy();
        int[] ratings = {1,0,2};
        System.out.println(obj.candy(ratings));
    }
}