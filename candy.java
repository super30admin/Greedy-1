//TC:O(n) - n no.of ratings
//SC:O(n)


class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int [] result = new int [n];
        Arrays.fill(result,1);
        for(int i=1;i<n;i++){//left comparision
            if(ratings[i]>ratings[i-1]){
                result[i] = result[i-1] + 1;
            }

        }
        for(int i=n-2;i>=0;i--){//right comparision
            if(ratings[i]>ratings[i+1]){
                result[i] = Math.max(result[i],result[i+1] + 1);
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){

            sum = sum+result[i];
        }
        return sum;
    }
} 