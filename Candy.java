// Time Complexity: O(n)
// Space Complexity: O(n)

/*
 * traverse through the array and if the rating is higher than the 
 * previous we increase the current value. then we do the same from the 
 * back and add it to the sum
 */

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i-1]){
                result[i] = result[i-1]+1;
            }
            
        }
        int sum = result[n-1];
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                result[i] = Math.max(result[i+1]+1, result[i]);
            }
            sum += result[i];
        }
        return sum;
    }
}