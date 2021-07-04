// Time Complexity :O(n) where n in the number elements in the vector
// Space Complexity : O(n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
public:
    int candy(vector<int>& ratings) {
        vector<int> candies(ratings.size(),1);
        for(int i = 1;i< ratings.size();i++){
            if(ratings[i] > ratings[i-1]) candies[i] = candies[i-1] + 1;
        }
        int sum = candies[ratings.size() - 1];
        for(int i = ratings.size()-2;i >= 0; i--){
            if(ratings[i] > ratings[i+1]) 
                candies[i] = max(candies[i],candies[i+1] + 1);
            sum+=candies[i];
        }
        return sum;
    }
};