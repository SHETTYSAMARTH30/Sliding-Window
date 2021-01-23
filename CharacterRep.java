class CharacterRep {
    public int characterReplacement(String s, int k) {
        
        //We have to use sliding window where the (size of window - max freq char) == (total number of changes reqd to make everything repeating) <= k. If its > k then the size of window must be decreased.
        
        int len = s.length();

        //Two pointers of window
        int left = 0, right;
        
        //maxChar = max repeating char in window of size windowSize
        int windowSize = 0, maxChar = 0;
        
        //Frequency of characters in the string
        int[] count = new int[26];
        
        for(right = 0; right < len; right++){
            
            char ch = s.charAt(right);
            
            //Calculating the size of window
            windowSize = right - left + 1;
            
            //Max character in current window
            maxChar = Math.max(maxChar, ++count[ch - 'A']);
            
            //Number of letters we need to change to make everything in window repeating
            int totalChangesReq = windowSize - maxChar;
            
            //Since we require max size, there is not point of shrinking window hence we never reduce the max size window
            //If changes required > K then window is invalid, hence we keep window size as same by removing letter from left
            if(totalChangesReq > k){
                
                //Since we push out a letter from window, we need to reduce its freq
                --count[s.charAt(left) - 'A'];
                left++;
            }
        }
        
        //Size of window
        return right - left;
        
    }
}
