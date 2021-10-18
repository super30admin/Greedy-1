//Time complexity:O(n)
//Space Complexity:O(n)
//running on leetcode: yes
class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length==0) return 0;
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        //check for left neighbor
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        //check for right neighbor
        int sum = candies[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], 1 + candies[i+1]);
            }
            sum += candies[i];
        }
        return sum;
    }
}
