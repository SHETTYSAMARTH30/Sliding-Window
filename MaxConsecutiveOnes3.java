class MaxConsecutiveOnes3 {
    public int longestOnes(int[] A, int K) {
        
        //We will create a sliding window where we will have 2 pointers left and right
        
        int left = 0, right;
        
        //Traverse entire array and find the maximum consecutive ones with max K zeroes
        for (right = 0; right < A.length; right++) {
            
      //If we included a zero in the window we reduce the value of K.
      //Since K is the maximum zeros allowed in a window.
      if (A[right] == 0) 
          K--;
            
      //A negative K denotes we have consumed all allowed flips and window has
      //more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
      if (K < 0) {
          
        //If the left element to be thrown out is zero we increase K.
        if (A[left] == 0) 
            K++;
          
        left++;
      }
            
    }
        
    return right - left;
        
    }
}
