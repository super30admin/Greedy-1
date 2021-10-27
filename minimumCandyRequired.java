// Time Complexity: O(2n)
// Space Complexity: O(n)
// Idea here is to in 1 pass check if any current element is greater than
// previous element, in that case get value of previous element's candy count and
// add to current element candy count.
// 2nd pass allows us to determine that if it already has more candies from previous then current already has max
// required candies, else 1 extra candy is given to current element
// final sum of all counts is returned.
class Solution {
    public int candy(int[] ratings) {
        if(ratings.length==0) return 0;
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        for(int i=1; i<ratings.length; i++) {
            if(ratings[i]>ratings[i-1]) res[i] = res[i-1]+1;
        }
        int sum = res[res.length-1];
        for(int i = ratings.length-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                res[i] = Math.max(res[i], res[i+1]+1);
            }
            sum+= res[i];
        }
        return sum;
    }
}