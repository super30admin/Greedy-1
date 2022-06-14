//BFS Solution
class Solution {

    // Time Complexity : 0(2^n) where n is the length of the array
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


    HashSet<Integer> set;   //Using a hashset to keep track of visited elements
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();  //For BFS traversal
        q.add(0);   //adding the 1st index to the queue
        set.add(0); //marking it as visited
        int level = 0;  //maintaining level to keep a track of jumps which inturn will give the final output
        while(!q.isEmpty()){
            int size = q.size();    //checking the size of the queue so that we can loop through thte size and find the possible jumps
            for(int i = 0; i < size; i++){  //looping till the size of the present queue
                int curr = q.poll();    //removing the element to check the no. of jumps we can take
                for(int j = 1; j <= nums[curr]; j++){   //checking all possible jumps we can make from that index
                    int jump = j + curr;    //calculating the index we can jump to
                    if(jump >= nums.length-1){  //if we have reached the last index, we simply return  level + 1 as level is starting from 0
                        return level + 1;
                    }
                    if(!set.contains(jump)){    //otherwise we check if we ave already seen visited the index or not. If not we add it to the queue for further computation and mark the index as visited
                        set.add(jump);
                        q.add(jump);
                    }
                }
            }
            level++;    //increasing the level as we have taken 1 jump from current index to next
        }
        return 54235;
    }
}

//Optiimzed approach

class Solution {


    // Time Complexity : 0(n) where n is the length of the array
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

    public int jump(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        int jumps = 1;  //a varibale to calculate the no. of jumps made
        int curr = nums[0]; //to store the index that can be reached by making the jump from the current index
        int next = nums[0]; //to store the max favourable jump from one index to another when several indexes are taken into account by jumping into differnet probabilities of index
        for(int i = 1; i < nums.length; i++){   //the loop starts from 1st index until the last. I start from 1st index as 0th index has already been taken care of
            next = Math.max(next, i + nums[i]); //storing the best possible index that can be reached from jumping from 1st index and the range of next possible jump
            if(i < nums.length - 1 && i == curr){   //If i is less than the nums. length-1 and if i is equal to current, as current is the total no. of jumps taht can be made from index i and we have taken all possible jumps into account storing the best jump
                jumps ++;   //I increment the jump as we take the next jump
                curr = next;    //also I set our curr to next as next holds the best value of the index that I can jump to
            }
        }
        return jumps;   //returning the jumps at the end
    }
}