class LongestContSubarrLimit {
    public int longestSubarray(int[] nums, int limit) {
        
        //Stores the max element index in the window
        Deque<Integer> max = new LinkedList<>();
        
        //Stores the minimum element index in the window
        Deque<Integer> min = new LinkedList<>();
        
        //We will use sliding window. In each window we take the diff between the max and min element (we dont need to diff between all elements in window as it will always be < that max - min), if its <= limit then we extend window. If not then we remove the max / min element from window ie whichever has lower index
        
        int left = 0;
        
        //Max size of window
        int result = 1;
        
        for(int right = 0; right < nums.length; right++){
            
            //We put the max element of window in list. If new element is max then we remove all the elements in list < nums[right] cuz its no longer useful
            while(max.size() != 0 && nums[max.peekLast()] < nums[right]){
                
                max.pollLast();
            }
            
            //If its not > max then we add it to end cuz if max is removed while sliding left pointer this will be new max. So the next maximum value will be max
            max.add(right);
            
            //We put min element in list. We will remove all the elements which are lesser than this element as we do max - min, so there is no point in keeping them.
            while(min.size() != 0 && nums[min.peekLast()] > nums[right]){
                
                min.pollLast();
            }
            
            min.add(right);
            
            //We find the diff between the max and min in the window, if its <= limit then we can increase window. Else we need to remove the elements from left
            while(Math.abs(nums[max.peekFirst()] - nums[min.peekFirst()]) > limit){
                
                //We will remove the element and bring left to new index
                int idx = -1;
                
                //Whoever has lower index should be removed as their diff is breaching the limit
                if(max.peekFirst() < min.peekFirst()){
                    
                    idx = Math.max(idx, max.poll());
                    
                }
                else{
                    
                    idx = Math.max(idx, min.poll());
                }
                
                //We move 1 index to right
                left = idx + 1;
            }
         
            //We keep track of the window size 
            result = Math.max(result, right - left + 1);
        }
        
        return result;
        
    }
}
