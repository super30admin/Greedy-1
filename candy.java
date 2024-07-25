import java.util.*;

class Solution {
    // Tc: O(n) Sc: O(n)
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;

        int n = ratings.length;
        int res[] = new int[n];
        int ans = 0;
        if (n == 1)
            return 1;
        Arrays.fill(res, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i], 1 + res[i + 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            ans = ans + res[i];
        }
        return ans;
    }
}