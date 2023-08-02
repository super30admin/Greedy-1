//Time Complexity = O(2N);
//Space Complexity = O(N);
//Method: iterate the array in two passes, one from first, other from last; when ever an element is greater than its previous element(neighbour) , its value would be max betweeen its' candy and previous element candy +1. In the left-right pass, right neighbours are calculated; in the other way left neighbours are calculated.
class Solution {
    public int candy(int[] ratings) {
        int sum =0;
        if(ratings.length ==0 || ratings == null)return 0;
        int[] result = new int[ratings.length];
        //give everyone one candy
        Arrays.fill(result,1);
        //forward
        for(int i =1; i< ratings.length ; i++){
            if(ratings[i] > ratings[i-1]) result[i] = result[i-1] + 1;
        }
        //backward
        sum = result[ratings.length -1];
        for(int i = ratings.length-2; i>=0 ; i--){
            if(ratings[i+1] < ratings[i]) result[i] = Math.max(result[i], result[i+1] + 1);
            // System.out.println(sum);
            sum += result[i];
        }

        return sum;

    }
}