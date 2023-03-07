135. Candy

TC- O(n)
SC = O(n)

class Solution {
public:
    int candy(vector<int>& ratings) {
        int n = ratings.size();
        if (n==0) return 0;
        if (n == 1) return 1;
        vector<int> result(n,1);
        int sum;
        result[1] = 1;
        for(int i=1; i<n; i++) {
            if(ratings[i] > ratings[i-1]) 
                result[i] = result[i-1] +1;
        }
        sum = result[n-1];
        for(int i=n-2; i>=0;i--) {
            if(ratings[i] > ratings[i+1]) {
                result[i] = max(result[i], result[i+1] +1);
            }
            sum = sum+result[i];
        }
        return sum;
    }
};

