import java.util.Arrays;

// Approach 1: Two Pass
// Time Complexity: O(n)
// Space Complexity: O(n)
public class LC135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                ans[i] = ans[i - 1] + 1;
        }
        int res = ans[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && ans[i + 1] + 1 > ans[i])
                ans[i] = ans[i + 1] + 1;
            res += ans[i];
        }
        return res;
    }
}

// Approach 2: Using Sorted Indices
// Time Complexity: O(nlogn)
// Space Complexity: O(n)
class LC135_1 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candies[] = new int[n];
        int res = 0;
        Arrays.fill(candies, 1);
        Integer sortedIndices[] = new Integer[n];
        for (int i = 0; i < n; i++)
            sortedIndices[i] = i;
        Arrays.sort(sortedIndices, (a, b) -> (ratings[a] - ratings[b]));
        for (int i = 0; i < n; i++) {
            int idx = sortedIndices[i];
            if (idx > 0 && ratings[idx] > ratings[idx - 1]) {
                candies[idx] = candies[idx - 1] + 1;
            }
            if (idx < n - 1 && ratings[idx] > ratings[idx + 1]) {
                candies[idx] = Math.max(candies[idx], candies[idx + 1] + 1);
            }
            res += candies[idx];
        }
        return res;
    }
}