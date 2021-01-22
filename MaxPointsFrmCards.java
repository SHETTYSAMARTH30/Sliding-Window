class MaxPointsFrmCards {
    public int maxScore(int[] cardPoints, int k) {
        
        //We can remove the cards from either left side or right side k times
        
        //It keeps the sum of k cards from left
        int leftSum[] = new int[k + 1];
        
        leftSum[0] = 0;
        
        //It keeps the sum of k cards from right
        int rightSum[] = new int[k + 1];
        
        rightSum[0] = 0;
        
        //Fill the leftSum and rightSum array with k cards from left
        for(int i = 1; i <= k; i++){
            
            leftSum[i] = cardPoints[i - 1] + leftSum[i - 1];
            
            rightSum[i] = cardPoints[cardPoints.length - i] + rightSum[i - 1];
        }
        
        //Now take 0 elements from left and k from right, then 1 from left and 2 from right and so on until k elements from left and 0 from right. Whichever has maximum sum return it
        
        int maxPoints = 0;
        
        for(int i = 0; i <= k; i++){
            
            //Imagine keeping 2 pointer one at start of leftSum and other at end of rightSum. Add them and keep track of max points
            maxPoints = Math.max(maxPoints, leftSum[i] + rightSum[k - i]);
        }
        
        return maxPoints;
    }
}
