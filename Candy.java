// TC: O(n) where n is the number of children.
// SC: O(n) where n is the number of children.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Candy {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        int[] result = new int[n];          // For candy allocation.
        // Arrays.fill(result, 1);
        // Check left neighbor.
        result[0] = 1;
        for(int i = 1; i < n; i++) {
            result[i] = 1;
            if(ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
        }
        // Check right neighbor.
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