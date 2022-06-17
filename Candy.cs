// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

 public int Candy(int[] ratings) {
    if(ratings == null || ratings.Length == 0)
        return 0;
    
    int n = ratings.Length;
    int[] result = new int[n];
    
    for (int i = 0; i < n;i++ ) {
        result[i] = 1;
    }
    
    //check with left neighbor
    for(int i = 1; i < n; i++)
    {
        if(ratings[i] > ratings[i-1])
            result[i] = result[i-1] + 1;
    }
    
    //start with right element
    int sum = result[n-1];
    //check with right neighbor
    for(int i = n-2; i >= 0; i--)
    {
        if(ratings[i] > ratings[i+1])
            result[i] = Math.Max(result[i], result[i+1] + 1);
        
        sum += result[i];
    }
    
    return sum;
}
