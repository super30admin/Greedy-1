
// time - O(n)
// space - O(n)

class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;

        int [] result = new int[n];

        Arrays.fill(result,1); // fill the array with 1


        for(int i = 1; i < n; i++) {
            // left pass
            if(ratings[i] > ratings[i-1]) {
                result[i] = result[i-1] + 1; // add +1 if the value is greater then the left element
            }

        }

        int sum = result[n - 1]; // start adding the sum from the last element
        for(int i = n - 2; i >= 0; i--) {
            // right pass
            if(ratings[i] > ratings[i + 1]) {
                result[i] = Math.max(result[i],result[i + 1] + 1); // find the max between current element and result+1 if thee value is greater then the right element
            }

            sum += result[i];

        }

        return sum;

    }
}