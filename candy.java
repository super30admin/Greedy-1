// TC =O(n)
// SC =O(n)
class Solution {
    public int candy(int[] ratings) {
        int s = 0;
        int n = ratings.length;
        int[] r = new int[n]; 
        if (n == 1) {
            return 1;
        }
        for (int i = 0; i < n; i++)
            r[i] = 1;
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i + 1] > ratings[i]) { 
                r[i + 1] = r[i] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]
                && r[i] <= r[i + 1]) {
                r[i] = r[i + 1] + 1;
            }
            s += r[i];
        }
        s += r[n - 1]; 
        return s;
    }
}