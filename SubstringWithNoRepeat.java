class SubstringWithNoRepeat {
    public int numKLenSubstrNoRepeats(String S, int K) {
        
        int len = S.length();
        
        //If string size is less than substring size
        if(K > len)
            return 0;
        
        //Starting point of sliding window
        int start = 0;
        
        //Number of substrings with no repeating char
        int count = 0;
        
        //Stores frequency of each character
        int[] freq = new int[26];
        
        for(int end = 0; end < len; end++){
            
            char c = S.charAt(end);
            
            //If char is already present in map, then substring will repeat. So we start new substring from next character after repeating char
            start = Math.max(start, freq[c - 'a']);
            
            //We store the next index of char, so that our start points to that index if this character repeats in future
            freq[c - 'a'] = end + 1;
            
             //We check whether size from start to i has reached K
            if(end - start + 1 == K){
                
                //The substring of size K has no repeat
                count++;
                
                //We have to remove the first char from window as we have reached size K
                start++;
                
            }
        }
        
        return count;
        
        
    }
}
