#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We track the slope changes to identify increasing and decreasing sequences.
When a slope change breaks a peak/valley, we compute candies using arithmetic progression formulas.
At the end, we tally candies from final slopes and return the total.
*/
class Solution{
    int count(int n){
        return n*(n+1)/2;
    }
public:
    int candy(vector<int>& ratings){
        int n = ratings.size();

        int up = 0, down = 0;
        int oldSlope = 0, newSlope = 0;
        int candies = 0;

        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]) newSlope = 1;
            else if(ratings[i] < ratings[i-1]) newSlope = -1;
            else newSlope = 0;

            if((oldSlope < 0 && newSlope >= 0) || (oldSlope > 0 && newSlope == 0)){
                candies += count(up) + count(down) + max(up, down);
                up = 0;
                down = 0;
            }
            if(newSlope == 1) up++;
            else if(newSlope == -1) down++;
            else candies++;
            oldSlope = newSlope;
        }
        candies += count(up) + count(down) + max(up, down);

        return candies + 1;
    }
};
