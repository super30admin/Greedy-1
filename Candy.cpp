#include<iostream>
#include<vector>
#include<numeric>
using namespace std;
class Solution {
public:
    int candy(vector<int>& ratings) {
        int n = ratings.size();
        vector<int>freq(n, 1); 
        for (int i=1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                freq[i] = freq[i-1] + 1;
            }
        }
        for (int i = n-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1]) {
               freq[i] = max(freq[i],freq[i+1]+1);
            }
        }
        return accumulate(freq.begin(),freq.end(), 0);
    }
};