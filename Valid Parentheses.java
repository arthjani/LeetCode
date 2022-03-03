class Solution {
   
    public boolean isValid(String s) {
      
        Stack<Character> stk = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stk.push(c);
            } 
            else if(stk.size() == 0) return false;
            else if (c == '}' && stk.peek() != '{') return false;
            else if (c == ')' && stk.peek() != '(') return false;
            else if (c == ']' && stk.peek() != '[') return false;
            else stk.pop();
        }
        
        return stk.size()==0;
           
           
    }
}