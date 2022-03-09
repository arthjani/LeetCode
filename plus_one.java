class Solution {
   
  
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        for (int i=n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] digits2 =new int[n+1];
        digits2 [0]=1;
        return digits2;
    }
    
    
    
}


// or


class Solution {
    public int[] plusOne(int[] digits) {
    int n = digits.length-1;
        for(int i = n ; i>=0 ; i--){
            if(digits[i]!=9){
                digits[i]++;
                break;
            }else{
                digits[i] = 0;
            }
            if (digits[0] == 0){
                int[] res = new int[digits.length+1];
                res[0] = 1;
                return res;
            }
        }
        return digits;
    }
} 