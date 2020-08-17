//Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    int candy(vector<int>& ratings) {
        if(ratings.size()==0) return 0;
        int candies[ratings.size()];
        int min_candies =0;
        //distribute minimum one candy to all children
        for(int i=0; i<ratings.size(); i++){
            candies[i]=1;
        }
        
        //fill the array left to right (comparison with one neighbor(left))
        for(int i=1; i<ratings.size(); i++){
            if(ratings[i]>ratings[i-1])
                candies[i]=candies[i-1]+1;
        }
        
        
        //fill the same array right to left (comparison with one neighbor(right))
        for(int i=ratings.size()-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                candies[i] = max(candies[i], candies[i+1]+1);
            }
        }
        
        for(int i=0; i<ratings.size();i++){
            min_candies+=candies[i];
        }
        
        return min_candies;
    }
};