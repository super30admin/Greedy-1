//time - O(n)
//space - O(n)
class Solution {
    public int candy(int[] ratings) {
        if(ratings==null && ratings.length==0) return 0;
        int n = ratings.length;
        int[] result = new int[n];
        int sum = 0;
        Arrays.fill(result, 1);

        for(int i=1; i<n; i++){
            if(ratings[i-1] < ratings[i]){
                result[i] = result[i-1]+1;
            }
        }

        sum+=result[n-1];

        for(int i=n-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                if(result[i] < result[i+1]+1){
                    result[i] = result[i+1]+1;
                }
            }
            sum+=result[i];
        }

        return sum;
    }
}
