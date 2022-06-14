class Solution {

    // Time Complexity : 0(n) where n is the length of the ratings array
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


    public int candy(int[] ratings) {
        int n = ratings.length;
        int [] result = new int[n]; //I am storing the no. of candies distributed to the children
        result[0] = 1;  //initializing the 1st index by 1
        //Pass 1-Right to left or comparing with left neighbor
        for(int i = 1; i < n; i++){ //beginning the traversal from 1 as I compare the prev rating to current
            result[i] = 1;  //initially initializing the current index as 1
            if(ratings[i] > ratings[i-1]){  //is the current index has higher rating than the left neighbor
                result[i] = result[i-1] + 1;    //then adding an extra candy to current
            }
        }
        //Pass 2= Left to right of comparing with right neighbor
        int sum = result[n-1];  //this calculates the total no of candies distributed in order to give the output
        for(int i = n-2; i >=0; i--){   //I begin with n-2 as I am comparing with the right neighbor
            if(ratings[i] > ratings[i+1]){  //if right neighbor has hisher rating
                result[i] = Math.max(result[i], result[i+1] + 1);   //then I take the max candies of the current index or the candies of right neighbor+1
            }
            sum = sum + result[i];  //I add the no. of candies to the sum
        }
        return sum; //I return the sum
    }
}