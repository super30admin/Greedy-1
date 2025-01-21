public class Candy {
     //slope logic - o(n)
     public int candy(int[] ratings) {
        int n = ratings.length;
        int up = 0, down = 0;
        int oldSlope = 0, newSlope = 0;
        int candies =0;
        //1 - increasing slope, -1 = decreasing, 0 = flat land 
        for(int i = 1;i < n; i++){
            newSlope = (ratings[i] < ratings[i-1]) ? -1 : ((ratings[i] > ratings[i-1]) ? 1 : 0);
            if((oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0)){
                candies += count(up) + count(down) + Math.max(up,down);
                up = 0;
                down = 0;
            }
            if(newSlope == 1){
                up++;
            }

            if(newSlope == -1){
                down++;
            }
            if(newSlope == 0){
                candies++;
            }
            oldSlope = newSlope;
        }
        candies += count(up) + count(down) + Math.max(up,down);
        return candies+1;
    }
    private int count(int n){
        return n * (n+1)/2;
    }


    //o(3n) and o(n)
    // public int candy(int[] ratings) {
    //     int n = ratings.length;
    //     int[] candies = new int[n];
    //     Arrays.fill(candies,1);
    //     for(int i = 1; i < n; i++){
    //         //first pass 
    //         if(ratings[i] > ratings[i-1]){
    //             candies[i] = candies[i-1]+1;
    //         }
    //     }
    //     for(int i = n-2; i >= 0; i--){
    //         //second pass 
    //         if(ratings[i] > ratings[i+1]){
    //             //if already has max candies no need to update 
    //             candies[i] = Math.max(candies[i],candies[i+1]+1);
    //         }
    //     }
    //     int total = 0;
    //     for(int i = 0; i < n; i++){
    //         total += candies[i];
    //     }
    //     return total;
    // }
}
