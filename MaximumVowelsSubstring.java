class MaximumVowelsSubstring {
    public int maxVowels(String s, int k) {
        
        //We will keep a sliding window of size k and count the number of vowels in it
        
        int left = 0, right;
        
        //Num of vowels in the each window
        int vowels = 0;
        
        for(right = 0; right < k; right++){
            
            if(isVowel(s.charAt(right)))
                vowels++;
        }
             
        //Keeps count of max vowels in a string of length k
        int maxVowels = vowels;
        
        //We will add each element to window from right and remove each from left and keep count of vowels
        for(right = k; right < s.length(); right++){
            
            if(isVowel(s.charAt(right)))
                vowels++;
            
            if(isVowel(s.charAt(left++)))
                vowels--;
            
            maxVowels = Math.max(maxVowels, vowels);
        }
        
        return maxVowels;
        
    }

    //Checks whether a given character is vowel or not
    public boolean isVowel(char c){
        
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        
        return false;
    }
}
