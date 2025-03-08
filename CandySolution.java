class CandySolution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int n = ratings.length, count = 0;
        int[] result = new int[n];

        Arrays.fill(result, 1);
        // 1st pass left to right
        for (int i = 1; i < n; i++) {
            // if lower than previous hold , if higher/equal add 1 to to it's prev
            if (ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
        }
        // 2nd pass right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                result[i] = Math.max(result[i + 1] + 1, result[i]);
            }
        }
        for (int i = 0; i < result.length; i++) {
            count = count + result[i];
        }
        return count;
    }
}