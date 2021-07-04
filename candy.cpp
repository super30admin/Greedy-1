/*
Intuition: To get the minimum candies, we first create an array of 1's

We can do a left to right pass, if the rating is greater than the previous ratings we add 1 to it.
Then we do a right to left pass, and do the same.

Time Complexity: O(N), N = Size of array
Space Complexity: O(N), N = Size of array
*/
class Solution {
public:
    int candy(vector<int>& ratings) {
        int result = 0;
        
        int candies[ratings.size()];
        for ( int i = 0; i < ratings.size(); i++) candies[i] = 1;
        
        
        for ( int i = 1; i < ratings.size(); i++){
            if ( ratings[i] > ratings[i-1]){       
                candies[i] = candies[i-1] + 1;

            }

        }
        
        
        for ( int i = ratings.size()-2; i >= 0; i--){
        
            if ( ratings[i] > ratings[i+1]){
            
                candies[i] = max( candies[i], candies[i+1] + 1);

            }

        }
        for ( auto el: candies) result += el;
        
        return result;
    }
};