import java.util.Arrays;

public class Candy {

    // TC : O(n) n - length of the ratings array
    // SC : O(n) since we're creating result array
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        // checking with the left neighbour
        for(int i=1; i < n; i++){
            if(ratings[i] > ratings[i - 1])
                result[i] = result[i-1] + 1;
        }

        // checking with the right neighbour
        int sum = result[n - 1]; // this we can do at the end also. But doing this here will avoid one more array pass
        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                result[i] = Math.max(result[i], result[i + 1] + 1); // if we blindly copy the right neighbour and add 1 then
                                                                        // it'll override whatever we did in the left pass
                                                                        // If it is already greater than right neighbour then keep it as it is
            }
            sum += result[i];
        }

        return sum;
    }

    // To avoid one pass where we initialize each element of the result array to 1
    public int candy2(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        int[] result = new int[n];

        result[0] = 1;
        // checking with the left neighbour
        for(int i=1; i < n; i++){
            result[i] = 1;
            if(ratings[i] > ratings[i - 1])
                result[i] = result[i-1] + 1;
        }

        // checking with the right neighbour
        int sum = result[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                result[i] = Math.max(result[i], result[i + 1] + 1);
            }
            sum += result[i];
        }

        return sum;
    }
}
