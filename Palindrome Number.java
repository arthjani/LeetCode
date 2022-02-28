class Solution {
    float y;
    public boolean isPalindrome(int x) {
         if (x<0){
             return false;
         }
        int num=x;
        int rev=0;
        while (num>0){
            rev = rev * 10 + num % 10;
            num = num/10;
        }
        return x==rev;
    }
}

//or 

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10==0 && x!=0))return false;
        int revert =0 ;
        while(x>revert){
            revert = revert *10 + x%10;
            x/=10;
        }
        return x==revert || x==revert/10;
    }
}