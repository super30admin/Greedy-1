/* 
    Time Complexity                              :  O(2*N) for the 2 passes
    Space Complexity                             :  O(N) to store the candies for each student.
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/candy

class Solution {
public:
    int candy(vector<int>& ratings) {
        int n=ratings.size();
        vector<int> candies(n);
        candies.at(0) = 1;
        for(int i=1;i<n;i++) {
            candies.at(i)=1;
            if(ratings.at(i) > ratings.at(i-1)) {
                candies.at(i)=candies.at(i-1)+1;
            }
        }
        
        int sum = candies.at(n-1);
        for(int j=n-2;j>=0;j--) {
            if(ratings.at(j) > ratings.at(j+1)) {
                candies.at(j) = max(candies.at(j),candies.at(j+1) + 1);
            }
            sum += candies.at(j);
        }
        
        return sum;
    }
};