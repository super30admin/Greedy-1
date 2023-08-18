// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int candy(int[] arr) {
        int n=arr.length;
        int a[]=new int[n];
        Arrays.fill(a,1);
        for(int i=0;i<n-1;i++){
            if(arr[i]<arr[i+1]){
                a[i+1]=1+a[i];
            }
        }
        for(int i=n-1;i>0;i--){
            if(arr[i]<arr[i-1]&&a[i-1]<=a[i]){
                a[i-1]=a[i]+1;
            }
        }
        int sum=0;
        for(int i:a)sum+=i;
        return sum;
    }
}

