// Time Complexity : O(N) # of elements
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach:
// 1. Traverse from first to last element and if current element is smaller than next element(child) add current # of candy's with 1 to next element. 
// 2. Everyone will start with 1 candy. Traverse from last to first and perform same operation if current is smaller than previous.  
// 3. Add all candy's to get the answer.

class Solution {
public:
    int candy(vector<int>& ratings) {
        int n= ratings.size();
        int arr[n+1];
        for(int i=0;i<n;i++){
            arr[i]=1;
        }
        for(int i=0;i<n-1;i++){
            if(ratings[i]<ratings[i+1] && arr[i+1]<=arr[i]){arr[i+1]=arr[i]+1;}
        }
        for(int i=(n-1);i>0;i--){
            if(ratings[i]<ratings[i-1] && arr[i-1]<=arr[i]){arr[i-1]=arr[i]+1;}
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans=ans+arr[i];
            cout<<arr[i]<<' ';
        }
        return ans;
    }
};