// Time Complexity = O(n)
// Space Complexity = O(n)

class Solution {
  public int candy(int[] ratings) {
    if(ratings == null || ratings.length == 0) return 0;
    int n = ratings.length;
    int[] candies = new int[n];
    Arrays.fill(candies, 1);
    // Check left neighbour
    for(int i = 1; i<n; i++) {
      if(ratings[i-1]<ratings[i]) {
        candies[i] = candies[i-1]+1;
      }
    }
    int total = candies[n-1];
    // Check right neighbour
    for(int i = n-2; i>=0; i--) {
      if(ratings[i]>ratings[i+1]) {
        candies[i] = Math.max(candies[i], candies[i+1]+1);
      }
      total += candies[i];
    }
    return total;
  }
}