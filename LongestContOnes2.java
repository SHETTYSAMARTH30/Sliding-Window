class LongestContOnes2 {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        //We will use a sliding window. If come across a single 0 then we consider it as 1 and increase window, but if our window contains 2 0's then we move the left until we push out a single 1. So our window becomes valid
        
        int left = 0, right = 0;
        
        int n = nums.length;
        
        int numZeroes = 0, maxWindow = 0;
        
        while(right < n){
            
            //We count num of 0's. It should not exceed 1
            if(nums[right] == 0){
                
                numZeroes++;
            }
            
            //If there are 2 0's in window then window is invalid hence we need to push 0's out by increasing the left and reducing the window
            while(numZeroes == 2){
                
                if(nums[left] == 0)
                    numZeroes--;
                
                left++;
            }
            
            //We keep track of largest continous sequence of 1's containing a single 0
            maxWindow = Math.max(maxWindow, right - left + 1);
            
            //expand our window
            right++;
        }
        
        return maxWindow;
        
    }
}
