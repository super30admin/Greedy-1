//O(n) + O(n) counting result array, else O(n) + O(1)
class Solution {
public:
    int candy(vector<int>& ratings) {
        vector<int> result(ratings.size(), 1);
        int sum = 0;
        for (int i = 1; i < ratings.size(); ++i) {
            if (ratings[i] > ratings[i - 1]) result[i] = result[i - 1] + 1;
        }
        sum = result[ratings.size() - 1];
        for (int i = ratings.size() - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1] && result[i] <= result[i + 1])
                result[i] = result[i + 1] + 1;
            sum += result[i];
        }
        return sum;
    }
};


