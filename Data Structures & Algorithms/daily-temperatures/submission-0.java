class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] op = new int[temperatures.length];
        Stack<int []> st = new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && st.peek()[1] < temperatures[i]){
                int[] temp = st.pop();
                op[temp[0]] = i - temp[0];
            }
            st.push(new int[]{i,temperatures[i]});
        }
        return op;
    }
}
