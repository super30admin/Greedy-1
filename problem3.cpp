/*
// Time Complexity : O(nlogn)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
arrange the index according to their ratigns. Go through the indexes and check their neighbourhood.
If they are greater than any of their neighbourhood increase it value by 1 from max of its neighbourhood.
*/



#include<iostream>
#include<vector>
#include<queue>

using namespace std;

class Node{
    public:
        int idx{};
        int val{};

        Node(int x, int y){
            this->idx = x;
            this->val = y;
        }
};

class Compare{
    public:
        bool operator()(Node* x,Node *y){
            if(x->val>y->val) return true;
            return false;
        }
};

class Solution {
    
public:
    int candy(vector<int>& ratings) {
        int sz = ratings.size();
        cout<<sz<<endl;
        // bool comp = [](gg& a,gg& b){
        //     return a.second<b.second;
        // };
        priority_queue<Node*,vector<Node*>,Compare> pq{};
        vector<int> res(sz,1);
        cout<<res.size()<<endl;
        for(int i{};i<sz;++i){
            Node* node = new Node(i,ratings.at(i));
            pq.push(node);
        }
        while(!pq.empty()){
            Node* node = pq.top();
            pq.pop();
            int idx = node->idx;
            int i = idx-1;
            int j = idx+1;
            //cout<<idx<<" "<<i<<" "<<j<<endl;
            if(i>=0){
                //cout<<"error"<<endl;
                if(ratings.at(idx)>ratings.at(i)){
                    //cout<<"error"<<endl;
                    int gg_val = res.at(i)+1;
                    res.at(idx) = max(res.at(idx),gg_val);
                }
            }
            if(j<sz){   
                //cout<<"error"<<endl;
                if(ratings.at(idx)>ratings.at(j)){
                    int gg_val = res.at(j)+1;
                    res.at(idx) = max(res.at(idx),gg_val);
                }
            }
        }
        int sum{};
        for(int& i:res){
            //cout<<i<<" ";
            sum += i;
        }
        cout<<endl;
        return sum;
    }
};

//2nd solution

class Solution {
public:
    int candy(vector<int>& ratings) {
        int sz = ratings.size();
        vector res(sz,1);
        for(int i{1};i<sz;++i){
            if(ratings.at(i)>ratings.at(i-1) && res.at(i)<=res.at(i-1)){
                res.at(i) = max(res.at(i),res.at(i-1)+1);
            }
        }
        int sum{res.at(sz-1)};
        for(int i{sz-2};i>=0;--i){
            if(ratings.at(i)>ratings.at(i+1) && res.at(i)<=res.at(i+1)){
                res.at(i) = max(res.at(i),res.at(i+1)+1);
            }
            sum+= res.at(i);
        }
        return sum;
    }
};