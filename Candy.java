class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        //left pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        int sum = arr[n-1];
        //right pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
            sum = sum + arr[i];
        }
        return sum;
    }
}
