// Time Complexity : O(2n) i.e. O(n)   
// Space Complexity : O(n)
// Did this code succesfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Initialize result vector with 1 candy per child and make 2 passes: fwd and backward
// 2. In the forward pass compare each child with its left neighbor and if curr has higher rating make its candies one more than left neighbor
// 3. Similarly, in the backward pass, if rating of curr child is more than right neighbor but candies is not more then make it 1 more than right neighbor

class Solution {
public:
    int candy(vector<int>& ratings) {
        int n=ratings.size();
        if(n==0)
           return 0;
        vector<int> result(n,1);
        // forward pass
        for(int i=1;i<n;i++)
            // curr rating higher than left neighbor
            if(ratings[i]>ratings[i-1])
                result[i] = result[i-1]+1;
        
        // backward pass
        for(int i=n-2;i>=0;i--)
            // curr rating higher than right neighbor but candies are not more
            if(ratings[i]>ratings[i+1] && result[i]<=result[i+1])
                result[i] = result[i+1]+1;
        
        int candies = 0;
        for(auto candy: result)
            candies+=candy;
        
        return candies;
    }
};