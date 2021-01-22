class LongestString395 {
    public int longestSubstring(String s, int k) {
        
        //We will perform divide and conquer and return the length of substring which has all the char freq >= k
        return findLongestSubstring(0, s.length(), s, k);
        
    }
    
    public int findLongestSubstring(int start, int end, String s, int k){
        
        //If k > than total length of string that we are checking then there wont be any max len substring
        if(k > end)
            return 0;

        //Frequency of char in s
        int count[] = new int[26];
        
        for(int i = start; i < end; i++){
            
            //Increase count
            count[s.charAt(i) - 'a']++; 
        }
        
        //We traverse string from start to end and if we find a character which is < k at any index ie mid then we divide string into start to mid - 1 and mid + 1 to end. Later we perform same step in both strings
        for(int mid = start; mid < end; mid++){
            
            //If a character is valid then continue else find the char position and perform divide and conquer to its left and right
            if(count[s.charAt(mid) - 'a'] >= k)
                continue;
            
            //The second half will start from next postion after mid
            int midStart = mid + 1;
            
            //To reduce computation time, we will check if neighboring elements after mid is valid or not. If not then we can ignore them
            while(midStart < end && count[s.charAt(midStart) - 'a'] < k)
                midStart++;
            
            //We found breakpt at midStart, recursively perform above steps in both left and right and then return max out of both
            int left = findLongestSubstring(start, mid, s, k);
            
            int right = findLongestSubstring(midStart, end, s, k);
            
            //It finds the len of longest string on left and right of invalid char. Return max
            return Math.max(left, right);
                  
        }
        
        //If entire string s is valid then this executes
        return end - start;
        
    }
}
