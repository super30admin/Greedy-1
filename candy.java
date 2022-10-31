//Time Complexity: O(N)
//Space Complexity: O(N)
class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int arr[]=new int[n];
        Arrays.fill(arr,1);
        int sum=0;
        for(int i=1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1] && arr[i]<=arr[i-1])
            {
                arr[i]=1+arr[i-1];
            }
        }
        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1] && arr[i]<=arr[i+1])
            {
                arr[i]=1+arr[i+1];
            }
        }
        for(int a:arr)
        {
            sum+=a;
        }
        return sum;
    }
}