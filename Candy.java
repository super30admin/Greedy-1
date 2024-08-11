/***
 TC - O(n)
 SC - O(n)
 */
class Candy {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) {
            return 0;
        }

        int n = ratings.length;

        int result[] = new int[n];
        result[0] = 1;

        for(int i =1; i < n; i++) {
            if(ratings[i] > ratings[i-1])
                result[i] = result[i-1] + 1;
            else
                result[i] = 1;
        }

        int count = result[n-1];

        for(int i =n-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1])
                result[i] = Math.max(result[i], result[i+1] + 1);

            count += result[i];
        }

        return count;
    }
}