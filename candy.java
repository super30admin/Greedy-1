// TC: O(n)
//SC: O(n)

public class candy {
    class Solution {
        public int candy(int[] ratings) {
        
            int [] arr = new int [ratings.length];
            int n = ratings.length;
            if(n==1)
                return 1;
            int sum =0;
            Arrays.fill(arr,1);
            for(int i=1;i< n;i++){
                if(ratings[i] > ratings[i-1]){
                    arr[i]=arr[i-1]+1;
                }
            }
            sum = arr[n-1];
            for(int i=n-2;i>= 0;i--){
                if(ratings[i] > ratings[i+1]){
                    arr[i]=Math.max(arr[i],arr[i+1]+1);
                }
                sum = sum+arr[i];
            }
            return sum;
        }
    }
}
