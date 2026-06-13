class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];
        for(int i=0;i<position.length;i++){
            int[] p = new int[2];
            p[0]=position[i];
            p[1]=speed[i];
            pairs[i]=p;
        }
        Arrays.sort(pairs, (a,b)->  Integer.compare(b[0],a[0]));
        Stack<Double> st = new Stack<Double>();
        for(int i=0;i<position.length;i++){
            double rem = (double) (((double)target - pairs[i][0])/pairs[i][1]);
            if(st.isEmpty()){
                st.push((double)rem);
                continue;
            }
            if(rem <= st.peek()){
                continue;
            }
            st.push((double)rem);
        }
        return st.size();
    }
}
