class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        
        //2 strings are anagram if they have same length and same char frequency
        
        //Stores the starting indexes of anagrams in s
        List<Integer> output = new ArrayList();
        
        int ns = s.length();
        int np = p.length();
        
        //s needs to >= p
        if(ns < np)
            return output;
        
        //To store frequency of char in window
        int[] s_count = new int[26];
        
        int[] p_count = new int[26];
        
        //Store the frequency of p
        for(char ch : p.toCharArray()){
            
            p_count[ch - 'a']++;
        }
        
        //Iterate the string s and compare whether 2 arrays are equal or not
        for(int i = 0; i < ns; i++){
            
            //We add an element to right
            s_count[s.charAt(i) - 'a']++;
            
            //If we have passed the 1st window then we need to remove 1 letter from start cuz we are sliding window
            if(i >= np){
                
                //We remove an element from the left
                s_count[s.charAt(i - np) - 'a']--;
            }
            
            //If 2 arrays are equal then save the start index ie i - np + 1
            if(Arrays.equals(s_count, p_count)){
                
                output.add(i - np + 1);
            }
        }
        
        return output;
        
    }
}
