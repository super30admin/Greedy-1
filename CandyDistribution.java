// Approach: From Brute Force where we fix the current element and check its left and right neighbours ratings.
// if their ratings are smaller than current child rating then candy distribution needs to be revisited as we progress.
// To avoid these iterations of recalculating the candy distribution we can do in a two pass approach - Greedy.
// 
// Time : O(n) + O(n) + O(n) = O(3n)
// Space : O(n)
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candys = new int[n]; // candies needed ofr each and every children
        Arrays.fill(candys,1); // By default all the children should have one candy atleast
        for(int i =1;i<n;i++){ // O(n)
            // first pass (left pass) - compare only with left neighbours
            // increasing ratings - scenario
            if(ratings[i]>ratings[i-1]){
                candys[i] = candys[i-1] +1;
            }
            // dont resolve if the ratings are decreasing// do nothing
        }
        // second pass (right pass) - where the ratings are in decreasing sceanrio
        for(int i =n-2;i>=0;i--){ // O(n)
            if(ratings[i]>ratings[i+1]){
                // if the children already has max candy then it should not be changed so max of
                candys[i] = Math.max(candys[i],candys[i+1]+1);
            }
        }

        int total = 0;
        for(int i =0;i<candys.length;i++){ // O(n)
            total+=candys[i];
        }

        return total;
    }
}