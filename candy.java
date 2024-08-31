/*
[5,4,2,3,6,2]
[1,1,1,2,3,1]

TC--> O(n)
SC --> O(1)
*/
class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;
        int[] res = new int[n];
        //move from left to right

        Arrays.fill(res,1);

        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                res[i] = res[i-1]+1;
            }
        }

        int sum_val = res[n-1];

        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                res[i] = Math.max(res[i], res[i+1]+1);
            }//if
            sum_val+=res[i];
        }//for

        return sum_val;

        
    }
}