// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Candy problem
class Solution {
    public int candy(int[] ratings) {

        int sum = 0;
        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result,1); //Giving each kid one candy
        //Left pass
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                result[i] = result[i-1] +1;
            }
        }

        //now right pass
        sum = result[n-1];
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                result[i] = Math.max(result[i],result[i+1]+1);
            }
            sum += result[i];
        }

        return sum;

        
    }
}
