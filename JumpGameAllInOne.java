

*******************************************Jump Game 1***********************************************

/*
Time complexity : O(n). n is the length of the array & I would be doing single pass through an array
Space complexity : O(1) Not using any extra memory
*/
class Solution {
    public boolean canJump(int[] nums) {
        //initially our finalDestination would be last index as we need to check if we can reach the
        //last index
        int finalDestination =nums.length-1;
        for(int i= nums.length-2; i>=0; i--){
            /*if from any index if we can reach the current final destination then I would 
            update the current final destination with current index and check if I can reach this 
            index from back
            */
            if(i+ nums[i] >=  finalDestination){
                finalDestination = i;
            }
        }
        //at last if my final destination is first index that mean i can reach the last index from 
        //first index
        return finalDestination ==0;
    }
}



*******************************************Jump Game 2**********************************************

/*
Time complexity : O(N), doing single pass through an array
Space complexity : O(1) 
*/
class Solution {
    public int jump(int[] nums) {
        //base case
        if(nums.length  == 1 ) 
            return 0;
        //farthest we can go by taking jump
        int farthest =0, scope=0;
        int jumps=0;
        for(int i=0; i< nums.length; i++){
            /* To minimize the number of jumps, with the help of "greedy" strategy and 
            choose the longest possible jump. */
           farthest = Math.max(farthest, i+nums[i]);
           if(farthest >= nums.length -1)
               return jumps+1;
            //need to do one more jump as I have reached the scope as I have exhaused maximum        
            //position reachable during the current jump.
           if(i == scope){
               jumps++;
               //scope would keep track of the maximum position reachable during the current jump.
               scope = farthest;
           }
        }
        return -1;
    }
}



*******************************************Jump Game 3*********************************************

/*
Time Complexity: O(N) as I would be terminating the recusrive call if I have already explored the 
current index by using visited set. So every index would be visited once.
Space Complexity: O(N) 
*/
class Solution {
    public boolean canReach(int[] arr, int start) {
        Set<Integer> visited = new HashSet<>();
        return canReachUtil(arr, start, set);
    }
    private boolean canReachUtil(int []arr, int start, Set<Integer>visited){
        //edge case: index goes out of bounce or we have already explored the current index
        if(start >= arr.length || start < 0 || visited.contains(start))
            return false;
        if(arr[start] == 0) 
            return true;
        //processing current index
        visited.add(start);
        //at every step we have 2 options: go to i+arr[i] or go to i-arr[i]
        //case1: i+arr[i]
        boolean case1= canReachUtil(arr, start+ arr[start], visited);
        //case2: i-arr[i]
        boolean case2= canReachUtil(arr, start- arr[start], visited);
        return case1 || case2;
    }
}

*******************************************Jump Game 4**********************************************
/*
Time Complexity: O(2n) = O(n) traversing every index twise. for creating map & while iterating
Space Complexity: O(3n) = O(n) Space for queue, map and set
*/
class Solution {
    public int minJumps(int[] arr) {
        Queue<Integer>q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int len =arr.length;
        q.add(0);
        set.add(0);
        //saving all the indexes in the list which has value equal to value at current index
        Map<Integer, ArrayList<Integer>>map = new HashMap<>();
        for(int i=0; i< len ; i++){
            if(!map.containsKey(arr[i]))
                map.put(arr[i], new ArrayList<>());
            
            map.get(arr[i]).add(i);
        }
        int jumps=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                int cur = q.remove();
                 //System.out.println(cur + " " + len);
                //reached the destination
                if(cur == len -1)
                    return jumps;
                // System.out.println(cur + " " + len);
                //we have 3 choices from each index
                //i + 1 where: i + 1 < arr.length.
                if(cur+1 < len && !set.contains(cur+1)){
                    set.add(cur+1);
                    q.add(cur+1);
                }
                //i - 1 where: i - 1 >= 0.
                if(cur-1 >= 0 && !set.contains(cur-1)){
                    set.add(cur-1);
                    q.add(cur-1);
                }
                //j where: arr[i] == arr[j] and i != j.
                //getting list of all j where arr[i] == arr[j] from map
                List<Integer> list = map.get(arr[cur]);
                for(int j : list){
                    if(j == cur) 
                        continue;
                    if(!set.contains(j)){
                        set.add(j);
                        q.add(j);
                    }
                }
                list.clear();   
            }
            jumps++;
        }
        return jumps;
    }
}
