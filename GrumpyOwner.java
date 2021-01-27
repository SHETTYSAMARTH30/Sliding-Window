class GrumpyOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        
        //Keep count of the inital customer satisfaction time
        int satisfactionTime = 0;
        
        int len = grumpy.length;
        
        //Count all the minutes when the owner wasn't grumpy
        for(int i = 0; i < len; i++){
            
            if(grumpy[i] == 0)
                satisfactionTime += customers[i];
        }
        
        //Now we will use a sliding window of size X to count the max minutes the customer is unsatified inside window of X size
        
        //Maximum unsatisfaction time in a window
        int windowTime = 0;
        
        int left = 0, right;
        
        //First we will count the initial unsatisfied minutes
        for(right = 0; right < X; right++){
            
            if(grumpy[right] == 1)
                windowTime += customers[right];
            
        }
        
        //Maximum unsatisfaction time 
        int maxWindowTime = windowTime;
        
        //Now we will slide the window for every X minutes. We will add the unsatisfaction time from right and remove unsatisfaction time from left
        for(right = X; right < len; right++){
            
            //If grumpy then add the minutes
            if(grumpy[right] == 1)
                windowTime += customers[right];
            
            if(grumpy[left] == 1)
                windowTime -= customers[left];
            
            //Max unsatisfaction time we recorded in a X minute window
            maxWindowTime = Math.max(windowTime, maxWindowTime);
            
            left++;
        }
        
        //Total of initial satisfaction time and max unsatisfied minutes in single window of size X
        return satisfactionTime + maxWindowTime;
         
    }
}
