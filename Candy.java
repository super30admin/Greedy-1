class Solution {
    //Time O(N)
    //Space O(N)
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
        {
            return 0;
        }
        int ans[] = new int[ratings.length];
        Arrays.fill(ans , 1);
        for(int i=1 ; i<ratings.length ; i++)
        {
            if(ratings[i] > ratings[i-1])
            {
                ans[i] = ans[i-1]+1;
            }
        }
        int sum = ans[ans.length-1];
        for(int i=ratings.length-2 ; i >= 0 ; i--)
        {
            if(ratings[i] > ratings[i+1])
            {
                ans[i] = Math.max(ans[i+1] +1 , ans[i]);
            }
            sum += ans[i];
        }
        return sum;
    }
}