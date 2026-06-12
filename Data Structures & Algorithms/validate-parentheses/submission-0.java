class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char[] car = s.toCharArray();
        for(int i=0;i<s.length();i++){
            System.out.println(st.size());
            if(car[i] =='[' || car [i] == '{' || car [i] == '('){
                st.push(car[i]);
                System.out.println(st.peek());
            }else if(car[i]==')' && (st.isEmpty() || st.pop()!= '(')){
                System.out.println("here");
                return false;
            } else if (car[i]==']' && (st.isEmpty() || st.pop()!= '[')){
                System.out.println("hi");
                return false;
            } else if(car[i] == '}' && (st.isEmpty() || st.pop()!= '{')){
                System.out.println("gh");
                return false;
            }
            System.out.println(st.size());
        }
        return st.isEmpty();
    }
}
