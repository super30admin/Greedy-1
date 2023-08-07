/*
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/

#include<vector>
#include<iostream>

using namespace std;

//dfs solution
//time limit exceeded

class Solution {
    bool flag{false};
    void helper(vector<int>& nums,int idx){
        //base
        if(idx >= nums.size()-1){
            flag = true;
            return;
        }
        //logic
        if(nums.at(idx)>0){
            for(int i{idx+1};i<=(idx+nums.at(idx)) && i<nums.size() && !flag;++i){
                //cout<<"outer loop"<<idx<<endl;
                if(i == nums.size()-1 || nums.at(i)>0){
                    //cout<<"inner loop"<<i<<endl;
                    helper(nums,i);
                }
                //cout<<endl;
            }
        }
    }
public:
    bool canJump(vector<int>& nums) {
        helper(nums,0);
        return flag;
    }
};

//dp DFS

class Solution {
    //bool flag{false};
    unordered_map<int,bool> umap{};
    bool helper(vector<int>& nums,int idx){
        //base
        if(idx >= nums.size()-1){
            return true;
        }
        if(umap.find(idx)!=umap.end())return umap[idx];
        //logic
        for(int j{nums.at(idx)};j>=1;--j){
            int nIdx = idx + j;
            bool result{false};
            if(umap.find(nIdx)==umap.end()){
                umap[idx] = helper(nums,nIdx);
            }
            //not directly sending umap[idx] makes us try other index values as well.
            result = umap[idx];
            if(result)return true;
        }
        return false;
    }
public:
    bool canJump(vector<int>& nums) {
        umap[0] = helper(nums,0);
        return umap[0];
    }
};

//greedy approach

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int sz = nums.size();
        if(sz==1)return true;
        int target = sz-1;
        for(int i{sz-2};i>=0;--i){
            if(nums.at(i)+i>=target){
                target = i;
            }
        }
        if(target == 0) return true;
        return false;
    }
};
