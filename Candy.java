//TC : O(n)
//SC : O(n)

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(ratings == null || n==0) return 0;
        if(n==1) return 1;
        int[] result = new int[n];
        Arrays.fill(result,1);
        for(int i=1;i<n;i++){
            if(ratings[i] > ratings[i-1] )
                result[i] = result[i-1]+1;
        }
        int cnt=result[n-1];
        for(int i=n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1] )
                result[i] = Math.max(result[i],result[i+1]+1);
            cnt += result[i];       
        }
        return cnt;
    }
}
