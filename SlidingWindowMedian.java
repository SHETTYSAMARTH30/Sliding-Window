class SlidingWindowMedian {
    
    TreeSet<Integer> minHeap, maxHeap;
    
    public double[] medianSlidingWindow(int[] nums, int k) {
    
        //In this we will create a min heap and max heap. 
        //Steps: 1-Put the element in min heap, 2-remove the element from min heap and put in the max heap, 3-If size of max heap > min heap then remove the top element of max heap and put in min heap, 4-If k = odd then the top of min heap is answer, If k = even then find the average of top of min and max heap.
        
        //If 2 elements are equal then arrange them by indices else ascending order
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        
        minHeap = new TreeSet<>(comparator);
        
        maxHeap = new TreeSet<>(comparator.reversed());
        
        int n = nums.length;
        
        double output[] = new double[n - k + 1];
        
        int left = 0;
        
        //This works like a sliding window.
        //In each window we calculate the median using the above steps in comments
        for(int right = 0; right < n; right++){
            
            //Remove the indices of the element from the left as the window progresses
            if(right >= k){
                
                minHeap.remove(right - k);
                maxHeap.remove(right - k);
            }
            
            //Add the element to min heap first
            minHeap.add(right);
            
            //Remove the first element from the min heap and add that to maxHeap
            maxHeap.add(minHeap.pollFirst());
            
            //It will balance the sizes if maxHeap > minHeap
            balanceHeaps();
            
            if(right >= k - 1){
                
                output[left++] = getMedian(nums, k);
            }  
        }
        
        return output;
        
    }
    
    //Calculates median
    public double getMedian(int[] nums, int k){
        
        //If k is even, then median = avg(top of minHeap and top of maxHeap)
        if(k % 2 == 0)
            return ((double) nums[minHeap.first()] + nums[maxHeap.first()]) / 2;
        
            return (double) nums[minHeap.first()];
    }
    
    //Balancing the size of heaps
    public void balanceHeaps(){
        
        //If max heap size is greater than min heap then pop the first element and put int min heap
        if(maxHeap.size() > minHeap.size())
            minHeap.add(maxHeap.pollFirst());

    }
    
}
