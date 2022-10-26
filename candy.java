// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int candy(int[] ratings) {

        if(ratings.length==0) return 0;

        int n = ratings.length;
        int[] res = new int[n];
        Arrays.fill(res,1);

        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                res[i] = res[i-1]+1;
            }
        }

        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1] && res[i]<=res[i+1]){
                res[i]=res[i+1]+1;
            }
        }
        int total=0;

        for(int i=0;i<n;i++){
            total += res[i];
        }

        return total;
    }
}