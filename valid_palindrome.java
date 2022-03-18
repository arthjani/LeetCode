class Solution {
    public boolean validPalindrome(String s) {
        
        int lo = 0, hi = s.length() - 1;
        int unMatchCount = 0;
        while(lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                unMatchCount++;
                if (unMatchCount > 1)
                    return false;
                
                return checkValidPalindrome(s.substring(lo, hi)) || checkValidPalindrome(s.substring(lo + 1, hi + 1));
            } else {
                lo++;
                hi--;
            }
        }
        
        return true;
    }
    
    public boolean checkValidPalindrome(String s) {
        if (s.length() == 1)
            return true;
        
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi))
                return false;
            lo++;
            hi--;
        }
        
        return true;
    }
    
}