// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


public class giveCandy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        
        int[] candiesArr = new int[n];
        
        Arrays.fill(candiesArr, 1);
        
        for(int i = 1; i < n; i++) {
            if(ratings[i - 1] < ratings[i]) {
                candiesArr[i] = candiesArr[i - 1] + 1;
            }
        }
        
        int candySum = candiesArr[n - 1];
        for(int j = n - 2; j >= 0; j--){
            if(ratings[j] > ratings[j + 1])
                candiesArr[j] = Math.max(candiesArr[j], candiesArr[j+1] + 1);
            candySum = candySum + candiesArr[j];
        }
        return candySum;
    }
}
