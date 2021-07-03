//time complexity O(2n) => O(n)
//space complexity O(n)

class Solution {
    public int candy(int[] ratings) {
        //edge case
        if(ratings == null || ratings.length == 0) return 0;
        int[] result = new int[ratings.length];
        int count = 0;
        Arrays.fill(result, 1);
        //Forward pass
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                result[i] = result[i-1] + 1;
            }
        }
        //Backward pass
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]){
                result[i] = Math.max(result[i], result[i+1] + 1);
            }
        }
        for(int ele: result){
            count += ele;
        }
        return count;
    }
}
