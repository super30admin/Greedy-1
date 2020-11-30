class Solution {//Using BFS time of O(n) and space of O(n)
    public boolean canReach(int[] arr, int start) {
        //[4,2,3,0,3,1,2], start = 5
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
            int idx = queue.poll();
            
            //check if the current index element is 0
            if(arr[idx] == 0)
                return true;
            if(arr[idx] <0)
                continue;
            if(arr[idx]+idx< arr.length)
                queue.add(arr[idx]+idx);
            if(idx-arr[idx]>=0)
                queue.add(idx-arr[idx]);
            //Marking visited
            arr[idx] = -1;
        }
        return false;
    }
}