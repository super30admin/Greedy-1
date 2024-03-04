//time O(2n)
//space O(n)
//approach: Left pass: give atleast one candy to everyone then in left pass keep increasing candy by one if the left neighbor is smaller. Then in right pass check if the candy is already larger number after left comparison or if the right neighbor+1 is larger.

class Solution {
    public int candy(int[] ratings) {
        // int[] candies = new int[ratings.length];
        // Arrays.fill(candies, 1);
        int count = 0;
        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        int sum = 0;
        //left pass
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                result[i] = result[i-1]+1;
            }
        }
        sum = result[n-1];
        for (int i = n -2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                result[i] = Math.max(result[i], result[i+1] + 1);
            }
            sum += result[i];
        }

        return sum;
    }
}
