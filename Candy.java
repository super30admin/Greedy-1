class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int count1[] = new int[n];
        for (int j = 0; j < n; j++) {
            count1[j] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                count1[i] = count1[i - 1] + 1;
        }
        int count2[] = new int[n];
        for (int k = 0; k < n; k++) {
            count2[k] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                count2[i] = count2[i + 1] + 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans += Math.max(count1[i], count2[i]);
        return ans;
    }
}