// Time Complexity : O(N) # of elements
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach:
// 1. Traverse each element and check maximum length of window which we get by finding we there is any element who can jump past current window maximum. 
// 2. If we found any element who can jump past current window, current's window max becomes current element's jump added with index. 
// 3. If we can't find such element and reach window max we will increase jump by 1 and current max jump becomes previous max jump found in that window.

class Solution {
public:
    map<int,int> m;
    void dfs(vector<int>& nums,int pt,int tr){
            if(nums.size()-1 <= pt){ return; }
            for(int i=1;i<=nums[pt];i++){
                if( ( (nums.size()-1) >= (pt+i) ) ) {
                    if( ! m.contains(pt+i) ){
                        m[pt+i]=m[pt]+1; 
                        cout<<m[pt+i]<<' ';
                        dfs(nums,pt+i,tr+1);
                    }else{
                        if(m[pt]+1 < m[pt+i]){
                            m[pt+i]= m[pt]+1;dfs(nums,pt+i,tr+1);
                        }
                    }
                }              
            }
            return;
    }
    int jump(vector<int>& nums) {
        int n=nums.size();
        int jump=0;
        int curmaxjump=0;
        int prevmaxjump=0;
        if(n == 1){return 0;}
        for(int i=0;i<n;i++){
            int curjumpitcantake=(nums[i]+i);
            if(curjumpitcantake>prevmaxjump){
                prevmaxjump=curjumpitcantake;
            }
            if(i==curmaxjump){
                jump++;curmaxjump=prevmaxjump;
                if(prevmaxjump>=n-1){break;}
            }
        }
        return jump;
    }
};