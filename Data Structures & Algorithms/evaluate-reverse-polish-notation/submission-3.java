class Solution {
    public int evalRPN(String[] tokens) {
        int op = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String curr = tokens[i];
            if(curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/")){
                int top = st.pop();
                int bTop = st.pop();
                if(curr.equals("+")){
                    st.push(top+bTop);
                }else if(curr.equals("-")){
                    st.push(bTop-top);
                }else if(curr.equals("*")){
                    st.push(top*bTop);
                }else{
                    st.push(bTop/top);
                }
            }else{
                st.push(Integer.parseInt(curr));
            }
        }
        return st.pop();
    }
}
