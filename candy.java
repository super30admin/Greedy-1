// Time Complexity : o(3n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 238


class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        
        int[] res = new int[ratings.length];
        Arrays.fill(res,1);
        for(int i = 1 ; i < ratings.length ; i++){
            if(ratings[i]>ratings[i-1]){
                res[i]=res[i-1]+1;
            }
        }
        for(int i = ratings.length - 2  ; i >= 0 ; i--){
            if(ratings[i]>ratings[i+1] ){
                res[i]= Math.max(res[i], res[i+1]+1);
            }
        }
        int sum = 0;
        for(int i = 0; i < ratings.length ; i++){
            // System.out.print(res[i]+ ", ");
            sum+=res[i];
        }
        
        return sum;
    }
}