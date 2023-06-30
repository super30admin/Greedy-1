// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
public:
    int candy(vector<int>& ratings) {
        int n = ratings.size();
        int total = 0;
        vector<int>result(n,1);
        for(int i = 1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                result[i] = result[i-1]+1;
            }
        }
        
        for(int i = n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                result[i] = max(result[i],result[i+1]+1);
            }
            total+= result[i+1];   
        }
        total+=result[0];
        return total;
    }
};