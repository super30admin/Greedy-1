// Time Complexity : O(N)
// Space Complexity : O(n), where n is the number of elements the user puts.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int candy(int[] ratings) {
        int[] candy= new int[ratings.length];

        Arrays.fill(candy,1);
    for(int i=1;i<ratings.length;i++){//updating the left neighbours
       if(ratings[i-1]<ratings[i])
           candy[i]=candy[i-1]+1;
    }

    int output= candy[ratings.length-1];
    for(int i=ratings.length-2;i>=0;i--){//pdating the right neighbours from end
        if(ratings[i]>ratings[i+1])
            candy[i]=Math.max(candy[i],candy[i+1]+1);
        output+=candy[i];
    }
    return output;
    }
}
