// Time Complexity : O(n)
// Space Complexity : O(n)
// Any problem you faced while coding this :

//I have started initially y creating a hashmap and storing the elements
//This didnt give good time and space complexity
//Hashmap is not required.
// Your code here along with comments explaining your approach
//1. Create a queue to store the possile indexes that can be reachde from starting point
//2. If an index is already mark as "-1" showing that the path has been explored
//3. if the index value is pointing to zero return true.

class Solution {
public:
    bool canReach(vector<int>& arr, int start) {
        //edge
        if(arr.size()==0)
            return true;
        
        //logic
        int size = arr.size();
        vector<int> count(size, 0);
        queue<int> index_queue;
        index_queue.push(start);
        count[start]=-1;
        
        while(!index_queue.empty()){
            int temp = index_queue.front();
            index_queue.pop();
            if(arr[temp] == 0)
                return true;
            int var1 = temp-arr[temp];
            if(var1 >=0 && count[var1] ==0){
                index_queue.push(var1);
                count[var1] =-1;
            }
            var1 = temp+arr[temp];
            if(var1 <=size-1 && count[var1] ==0){
                index_queue.push(var1);
                count[var1] =-1;
            }
            
        }
        return false;
        
    }
};
