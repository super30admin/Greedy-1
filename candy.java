// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes

class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        // checking left neighbour
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                // if left neighbour has less rank, we'll give one more candy than prev
                result[i] = result[i - 1] + 1;
            }
        }
        int sum = result[n - 1];
        // checking right neighbour
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // if right neighbour has less rank, we'll give max of one more candy than prev
                // and curr candy
                result[i] = Math.max(result[i], result[i + 1] + 1);
            }
            sum += result[i];
        }

        return sum;
    }
}