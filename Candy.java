// Time Complexity : O(3N)
// Space Complexity : O(N) - result array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int result[] = new int[n];
        //O(N)
        Arrays.fill(result, 1);

        //O(N)
        for(int i=1;i< n;i++){
            if(ratings[i] > ratings[i-1]) {
                result[i] = result[i-1] + 1;
            }
        }

        int sum =result[n-1];
        O(N)
        for(int i=n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]) {
                result[i] = Math.max(result[i] , result[i+1]+1);
            }
            sum+= result[i];
        }

        return sum;
    }
}