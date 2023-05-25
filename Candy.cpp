// Time Complexity - O(n)
// Space Complexity - O(n)

class Solution {
public:
    int candy(vector<int>& ratings) {
        int n = ratings.size();
        if(n == 1)
            return 1;
        
        vector<int> candyCount(n, 1);
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1])
                candyCount[i] = candyCount[i-1]+1;
        }
        
        int totalCandies = candyCount[n-1];
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1])
                candyCount[i] = max(candyCount[i], candyCount[i+1]+1);
            totalCandies += candyCount[i];
        }
        return totalCandies;
    }
};