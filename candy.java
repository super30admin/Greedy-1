// Time Complexity : O(n), where n is the size of the input array (exactly O(4n), O(n) to fill array with 1's, O(n) to forward 
                    //distribute the candies, O(n) to backward distribute the candies, O(n) to count the total candies)
// Space Complexity : O(n), where n is the size of the input array (array to store the number of candies for each child)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner explanation of your approach in plain English
//1. Create a an array to store the total candies for each child. initially add 1 to all the indices to denote 1 minimum candy for 
        //each child
//2. Forward traverse the array from index 1 and if the ranking is higher than its previous child give one more candy to the current 
            //child than its previous child.
        //Similiarly, Backward traverse the array from second last index and if it's ranking is higher than than it's previous child,
            //the number of candies for the current child will be the maximum between the candies the current child already has and 
            //one more candy than its previous child
//3. In the end, count the total number of candies in the array and return
//Intuition -> You try to assign a childm number of candies w.r.t to first his right neighbour and then his left neighbour (one at
                //a time)

// Your code here along with comments explaining your approach

class Solution {
    public int candy(int[] ratings) {
        //edge case
        if(ratings == null || ratings.length == 0) return 0;
        
        int n = ratings.length;
        //result array
        int[] result = new int[n];
        //total candy count 
        int count = 0;
        //assign 1 minimum candy to all the children
        Arrays.fill(result, 1);
        
        //forward distribute candies
        for(int i=1; i<n; i++){
            //if rank of the current child is greater than the previous child give him one more candy than the prvious child
            if(ratings[i] > ratings[i-1]){
                result[i] = result[i-1] + 1;
            }
        }
        
        //backward distribute the candy
        for(int i=n-2; i>=0; i--){
            //if rank of the current child is greater than the previous child then the number of candies for this child will be 
            //maximum of his already existing candies and 1 more than the previous child's candy
            if(ratings[i] > ratings[i+1]){
                result[i] = Math.max(result[i], result[i+1] + 1);
            }
        }
        
        //count the candies
        for(int i=0; i<n; i++){
            count += result[i];
        }
        
        return count;
    }
}