// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem3 {
    //TC:O(2N)+N
    //SC:O(N)
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies,1);
        //left pass to indentify only increasing curve and add 1 more than the neigbour
        for(int i= 1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }


        for(int i= n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i]=Math.max(candies[i],candies[i+1]+1);
            }
        }
        int count =0;
        for(int i= 0;i<n;i++){
            count+=candies[i];
        }

        return count;
    }
}
