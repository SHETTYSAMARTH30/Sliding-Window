class MinimuWindowSub {
    public String minWindow(String s, String t) {
        
        if(s.length() == 0 || t.length() == 0)
            return "";
        
        //Steps: We will count the frequency of characters in t and store in map. Then we use a sliding window across s. If all the characters which are present in t is present in the window then we calculate the size.
        
        //Count the frequency of characters in t
        Map<Character, Integer> count = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++){
            
            char c = t.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        //Number of unique characters in t
        int required = count.size();
        
        //If required is same as formed then we stop sliding window as we have found t
        int formed = 0;
        
        //To keep the count of characters in window. All the characters must also have same count as characters in t
        Map<Character, Integer> windowCount = new HashMap<>();
        
        //2 pointers of sliding window
        int left = 0, right = 0;
        
        //Result:- 0- minimum sliding window, 1- its left index, 2- its right index
        int ans[] = {-1, 0, 0};
        
        while(right < s.length()){
            
            char c = s.charAt(right);
            
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
            
            //If the frequency of 1 characters is fulfilled ie 1 character frm t is found
            if(count.containsKey(c) && count.get(c).intValue() == windowCount.get(c).intValue()){
                
                formed++;
            }
            
            //If we have found all the characters in t then formed and required becomes equal, so we save window size and shrink the window from left until required becomes < formed
            while(left <= right && formed == required){
                
                //If the new window is less than previous the update
                if(ans[0] == -1 || ans[0] > (right - left + 1)){
                    
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                
                //Now we starting removing characters from the left
                char ch = s.charAt(left);
                
                //Since we removed ch we reduce the count
                windowCount.put(ch, windowCount.get(ch) - 1);
                
                //If we have removed a character which was present in t then we have to reduce required
                if(count.containsKey(ch) && windowCount.get(ch).intValue() < count.get(ch).intValue())
                    formed--;
                
                //Increment the left pointer to remove next value
                left++;
            }
            
            right++;
        }
        
        //We return the substring from its left and right index
        return ans[0] == -1 ? "": s.substring(ans[1], ans[2] + 1);
          
    }
}
