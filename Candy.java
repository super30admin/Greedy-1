
//time complexity is O(N)
//Space complexity is O(N)
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] dp1 = new int[n];
        int c=0;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                c=c+1;
                dp1[i]=c;
            }
            else{
                c=0;
                dp1[i]=c;
            }
        }
        int[] dp2=new int[n];
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                c=c+1;
                dp2[i]=c;
            }
            else{
                c=0;
                dp2[i]=c;
            }
        }
        int result=n;
        for(int i=0;i<n;i++){
            result=result+Math.max(dp1[i], dp2[i]);
        }
        return result;
    }
}



