// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int candy(vector<int>& ratings) {
        if(ratings.size()==0){
            return 0;
        }
        vector<int> result(ratings.size(), 1);
        for(int i=0;i<result.size();i++){
        }
        for(int i=1;i<ratings.size();i++){
            if(ratings[i]>ratings[i-1]){
                result[i] = result[i-1]+1;
            }
        }
        for(int j=ratings.size()-2;j>=0;j--){
            if(ratings[j]>ratings[j+1]){
                result[j] = max(result[j], result[j+1]+1);
            }
        }
        int sum = 0;
        for(int i:result){
            sum = sum+i;
        }
        return sum;
    }
};
