// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : iterate through array left to right. Maintain an array, if curr rating is greater than prev element, give that person 1 extra candy
/// than predecessor. Repeat again from right to left. At the end sum up all of max(left[i], right[i])
class Solution {
    public int candy(int[] ratings) {
        int left[] = new int[ratings.length];
        Arrays.fill(left, 1);
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                left[i] = left[i-1]+1;
            }
        }
        int candy = left[ratings.length-1];
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                left[i] = Math.max(left[i], left[i+1]+1);
            }
            candy += left[i];
        }
        return candy;
    }
}