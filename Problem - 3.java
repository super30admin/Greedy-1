// Time Complexity :(O(2n))
// Space Complexity :(O(n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
We can solve this with greedy approach:

Since we have to compare each element with its neighbors, doing that in one go would not yeild the proper result
The question states that each child must have atleast 1 candy, so we will distribute one candy to each child
We can go from left to right in one pass , and from right to left in another pass

which means that we are comparing each element with left and right but in seperate pass, as in one pass it would breach the conditions

we will store how many candies each child is having in a seperate Arrays

from left to right , we will compare each element element with its prev(left) element, if the element is greater, then we would take the max between the prev value +1 and current value , and store it in that index

from right to left , we will compare each element with its next(right) element, if the element is greater, then we would take the max between the next value +1 and current value , and store it in that index

at the end we will count the values

T:(O(2n))
S:(O(n))
*/
class Solution {
    public int candy(int[] ratings) {

        int[] result = new int[ratings.length];
       // Arrays.fill(result,1);
        int count=0;
        count+= ratings.length; // giving each child atleast one candy

        // go from left to right
        for(int i=1;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1] ){
               result[i] = Math.max(result[i], result[i-1]+1);
            }
        }
        //go from right to left
        for(int i=ratings.length -2;i>=0;i--){
        if(ratings[i] > ratings[i+1] ){
                result[i] = Math.max(result[i], result[i+1]+1);
            }
        count+=result[i];
    }

    count+= result[ratings.length-1]; // the last index was left on the last iteration so adding its value here as well

    return count;
}
}