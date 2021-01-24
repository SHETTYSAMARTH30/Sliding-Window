class LongestSubstringKDiffChar {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        //we will use sliding window across the string. If at any pt the num of unique char in window > k then window is invalid so we reduce window size.
        
        int len = s.length();
        
        //If either string is empty or k is 0 then result will be 0
        if(len * k == 0)
            return 0;
        
        int left = 0;
        int right = 0;
        
        //Now string will atleast be of size 1
        int windowSize = 1;
        
        //We use this instead of HashMap cuz we can get elements in insertion order. 
        //In HashMap to remove a righmost index from window we will have to search the entire map but here the rightmost will be the first element
        Map<Character, Integer> rightMostPosition = new LinkedHashMap<>();
        
        while(right < len){
            
            Character c = s.charAt(right);
            
            //If character already present then remove old index and put new index
            if(rightMostPosition.containsKey(c)){
                
                rightMostPosition.remove(c);
            }
            
            //Put char and its index
            rightMostPosition.put(c, right++);
            
            //If there are more than k unique letters then remove leftmost unique element and reduce size of window
            if(rightMostPosition.size() == k + 1){
                
                //Set pointer to first index of map
                Map.Entry<Character, Integer> leftMost = rightMostPosition.entrySet().iterator().next();
                
                //Fetch the index of the element that needs to be removed from window
                left = leftMost.getValue() + 1;
                
                //Remove element from map
                rightMostPosition.remove(leftMost.getKey());
  
            }
            
            //Keep track of max window size. We do not do +1 cuz right is incremented above already
            windowSize = Math.max(windowSize, right - left);
            
        }
        
        return windowSize;
        
    }
}
