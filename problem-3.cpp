// t-c: n;
// s-c: n;
class Solution {
public:
    int candy(vector<int>& ratings) {
        int minCandies = 0, n = ratings.size();
        vector<int> candies(n, 1);
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }
        minCandies += candies[n-1];
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = max(candies[i], candies[i+1] + 1);
            }
            minCandies += candies[i];
        }
        return minCandies;
    }
};
