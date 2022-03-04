class Solution {
    public String convert(String s, int numRows) {
        String result = "";
        
        
        // interval between major coloums
        int interval = 2*numRows - 2;
        if(interval < 1)
            return s;
        // transverse through each row
        for(int i = 0; i < numRows ; i++){
            // step is for printing the spaces between characters 
            int step = interval - 2*i;
            // transverse through character starting after s[i], inclusive
            // increamenting based on the interval between characters 
            // because of the zigzag pattern
            for(int j = i ; j < s.length() ; j = j + interval)
            {
                // priting the char at first
                result += s.charAt(j);
                //System.out.print(s.charAt(j));
                // check if the step for printing the spaces is bigger than 0 and less than the interval 
                if(step > 0 && step < interval && step + j < s.length()){
                    for(int k = 0 ; k < (interval - numRows - i) ; k++)
                        result += " ";
                    
                    result += s.charAt(j + step);
                        
                    for(int k = 0 ; k < (i-1) ; k++)
                        result += " ";
                }
                else{
                    for(int k =0 ; k < (interval - numRows) ; k++)
                        result += " ";
                }
            }
        }
        
        String finalResult = "";
        for(int i = 0 ; i < result.length(); i++){
            if(result.charAt(i) == ' ')
                continue;
            finalResult += result.charAt(i);
        }
        System.out.println(finalResult);
         return finalResult;
    }
    
}


//or

class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
         
        char[] res =new char[s.length()];
        int index = 0;
        int row = 0;
        int interval = 0;
        
        int i=0;
        while(i<res.length){
            res[i++] = s.charAt(index);
            if(row!=0 && row!=numRows-1){
                if(i<res.length && index+interval<s.length()){
                    res[i++] = s.charAt(index+interval);
                }
            }
            index += numRows*2-2;
            if(index>s.length()-1){
                row++;
                index=row;
                interval = (numRows-1-row)*2;
            }
        }
        
        return String.valueOf(res);
    }
}