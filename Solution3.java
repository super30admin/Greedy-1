// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution3 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        for(int i = 1; i < n; i++) {
            if( ratings[i] > ratings[i-1]) {
                cnt[i] = cnt[i-1] + 1;
            }
        }
        for(int i = n-2; i >= 0; i--) {
            if( ratings[i] > ratings[i+1] ) {
                if( cnt[i] == cnt[i+1]) {
                    cnt[i]++;
                } else if ( cnt[i] < cnt[i+1] ) {
                    cnt[i] = cnt[i+1] + 1;
                }
            }
        }
        int sum = 0;
        for(int s: cnt) {
            sum = sum + s;
        }
        return sum;
    }
}
