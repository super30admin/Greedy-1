//Time Complexity: O(n)
//Space Complexity: O(1)
//Greedy Approach

class Solution {    
    public boolean canJump(int[] A) {
        //base case
        if(A == null || A.length < 2)
            return true;
        
        //last index of the array A
        int lastIndex = A.length-1 ;
        //from last to first index
        for(int i = A.length-1; i >= 0; i--)
        {
            //if ith index + vlue at that index is > or = lastIndex
            if(i + A[i] >= lastIndex) 
            {
                //initialize lastIndex with i
                lastIndex = i;
            }
        }
        //if lastIndex can be reached and is == 0; return true
        //else return false
        return lastIndex == 0;
    }
}