class SlidingWindowMaximum {
    
    //It will the store the index of the maximum element in the window
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    
    int[] nums;
    
    public void clean_deque(int i, int k){
        
        //Keep the indices of elements of current window, push out from left
        if(!queue.isEmpty() && queue.getFirst() == i - k)
            queue.removeFirst();
        
        //Remove indexes of all elements smaller than the current one, since they will not be the maximum ones in future
        while(!queue.isEmpty() && nums[i] > nums[queue.getLast()])
            queue.removeLast();
        
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;

        //If nums is empty or k = 0 then we get no ans
        if(n * k == 0)
            return new int[0];
        
        if(k == 1)
            return nums;
        
        this.nums = nums;
        
        //Stores the result
        int[] output = new int[n - k + 1];
        
        //We will keep a sliding window of size k and store the max element that we come across in the deque
        
        for(int right = 0; right < n; right++){
            
            //Clean all the elements that is not required for current window
            clean_deque(right, k);
                
            //Then we add the index to queue. Even if its not maximum in queue we add it to end thinking that as we move window if max element is pushed out this might be next max element
            queue.addLast(right);
            
            //The first element in queue will always be the max element in that window so add that to result
            if(right >= k - 1)
                output[right - k + 1] = nums[queue.getFirst()];

        }
        
        return output;
    }
}
