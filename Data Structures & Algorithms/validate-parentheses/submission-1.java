class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] car = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(car[i] =='[' || car [i] == '{' || car [i] == '('){
                st.push(car[i]);
            }else if(car[i]==')' && (st.isEmpty() || st.pop()!= '(')){
                return false;
            } else if (car[i]==']' && (st.isEmpty() || st.pop()!= '[')){
                return false;
            } else if(car[i] == '}' && (st.isEmpty() || st.pop()!= '{')){
                return false;
            }
        }
        return st.isEmpty();
    }
}
