class Solution {

    // Time Complexity : 0(n) where n is the length of nums
// Space Complexity :   0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2){    //if there is no element or only 1 element in the nums array, I return true
            return true;
        }
        int destination = nums.length-1;    //I am traversing from the last index to 1st
        for(int i = nums.length - 2; i >=0; i--){   //the loop starts from length -2 as I am comparing the sum of nums[i] and i with destination
            if(i + nums[i] >= destination){ //if it is greater than or equal to the destination, then I reset my destination at i as it indicates that there exists a jump by which I can reach the final destination
                destination = i ;
            }   //if not, then I move towards left searching for the above condition
        }
        return destination == 0;    //at the end, if destination's value is 0, means I have reached the start index and there exists jumps through which I can reach the last index
    }
}

//BFS solution

class Solution {

    // Time Complexity : 0(2^n) where n is the length of nums
// Space Complexity :   0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    HashSet<Integer> set; //I take a hashset to keep a track of the visited indexes so that I don't add an already seen index again to the queue
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2){
            return true;
        }
        set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();  //Queue for a BFS approach where I add the indexes that i can make valid jumps to
        q.add(0);   //initially I add 1st index to my queue
        set.add(0); //also add it to my visited array
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int i = 1; i <= nums[curr]; i++){   //the for loop runs for the value present in the nums array marking the no. of possible jumps it can make from that index
                int jump = i + curr;    //i add the index and jump starting from 1 checking all possible probabilities to jump from that particular index
                if(jump == nums.length-1){  //if I make a jump that lands me at the last index, I return true
                    return true;
                }
                if(!set.contains(jump)){    //If not, I add the unseen index to my queue as well as to my visited set
                    set.add(jump);
                    q.add(jump);
                }
            }
        }
        return false;   //If the if condition is not hit meaning I am not able to reach the last index hence returning false
    }
}
//DFS Solution
class Solution {
    HashSet<Integer> set;
    public boolean canJump(int[] nums) {
        if(nums. length < 2 || nums == null){
            return true;
        }
        set = new HashSet<>();
        return dfs(nums, 0);
    }
    public boolean dfs(int [] nums, int index){
        //base
        if(set.contains(index)){
            return false;
        }
        if(index == nums.length-1){
            return true;
        }
        //logic
        set.add(index);
        for(int i = 1; i <= nums[index]; i++){
            int curr = i + index;
            if(dfs(nums, curr)){
                return true;
            }
        }
        return false;
    }
}