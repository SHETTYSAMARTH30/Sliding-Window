class MinSwapsGrp1 {
    public int minSwaps(int[] data) {
        
        //To count number of swaps we will first count the number of ones in array. Then we use a sliding window of that same size and count num of 0's in that window cuz that many swaps will be required to make array continous.
        
        int left = 0, right;
        
        //Count total num of 1's in array
        int num_ones = 0;
        
        for(int i : data){
            
            num_ones += i;
        }
        
        //Maximum num of ones in any window
        int maxCount = 0;
        
        //Total num of ones in current window
        int cntOnes = 0;
        
        for(right = 0; right < data.length; right++){
            
            cntOnes += data[right];
            
            //If window exceeds the num of ones
            if(right - left >= num_ones){
                
                //Then remove one element from left, so that window is of size of num of ones. Then move the left pointer
                cntOnes -= data[left++];
            }
            
            //We will store the maximum number of ones we found in any window
            maxCount = Math.max(maxCount, cntOnes);
            
        }
        
        //The minimum swaps will always be in a window which has max num of 1's cuz there will be less 0's hence less swaps required.
        return num_ones - maxCount;
        
    }
}
