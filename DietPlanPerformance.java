class DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        
        //We use sliding window/2 pointers to make complexity-O(N)
        
        //It keeps the sum of all the calories in window of length k
        int rollingSum = 0;
        
        //It keeps the points earned
        int performancePoints = 0;
        
        for(int i = 0; i < calories.length; i++){
            
            //We add the calorie
            rollingSum += calories[i];
            
            //If we have not reached 2nd last positn of first window of size k yet
            if(i < k - 1){
                continue;
            }
            
            //After we have reached k, we keep on increasing our window. It is done by discarding the first element by subtracting and adding the new element
            if(i >= k){
                
                rollingSum -= calories[i - k];
            }
            
            
            if(rollingSum < lower)
                performancePoints--;
            
            if(rollingSum > upper)
                performancePoints++;
            
        }
        
        return performancePoints;
    }
}
