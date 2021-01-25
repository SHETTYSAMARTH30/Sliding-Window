class PermutationString {
    public boolean checkInclusion(String s1, String s2) {
        
        //Here s1 or any anagram of s1 must be a substring of s2. We can use brute force but we can use sliding window also.
        //Anagram:- Both window of same length and must have same frequency of characters.
        
        int len1 = s1.length();
        
        int len2 = s2.length();
        
        //s1 must be <= s2
        if(len1 > len2)
            return false;
        
        //2 pointers of the window
        int left = 0, right = 0;
        
        //Stores the freq of characters in the window
        int s1Count[] = new int[26];
        
        int s2Count[] = new int[26];
        
        //Store the frequency of char in the first window
        while(right < len1){
            
            s1Count[s1.charAt(right) - 'a']++;
            
            s2Count[s2.charAt(right) - 'a']++;
            
            right++;
        }
        
        //Now we have stored the frequency of s1 which will be same throughout. We just have to compare s1Count with each window of s2
        //We will bring right to end of window1
        right--;
        
        //Create windows for s2 and see if it matches s1
        while(right < len2){
            
            //If both window and s1Count have same frequency then it means they have same characters
            if(matches(s1Count, s2Count))
                return true;
            
            //Else we increase the right and left
            right++;
            
            //If we have not completed iterating entire s2
            //Add new element to window
            if(right != len2){
                
                s2Count[s2.charAt(right) - 'a']++;
            }
            
            //Remove left element from window
            s2Count[s2.charAt(left) - 'a']--;
            left++;
        }
        
        return false;  
    }
    
    //We check whether 2 arrays equal or not
    public boolean matches(int[] freq1, int[] freq2){
        
        for(int i = 0; i < 26; i++){
            
            if(freq1[i] != freq2[i])
                return false;
        }
        
        return true;
    }
       
}
