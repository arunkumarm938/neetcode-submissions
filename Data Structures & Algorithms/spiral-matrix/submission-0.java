class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int a = matrix.length;
        int b = matrix[0].length;
        int k = 0;
        int c = a * b;
        List<Integer> list = new ArrayList<>();
        int ct = 0;
        while(k <= a && k <= b && ct < c){
            for(int l=k;l<b && ct < c;l++){
                list.add(matrix[k][l]);
                ct++;
            }
            for(int l=k+1;l<a && ct < c;l++){
                list.add(matrix[l][b-1]);
                ct++;
            }
            for(int l=b-2;l>=k && ct < c ;l--){
                list.add(matrix[a-1][l]);
                ct++;
            }
            for(int l=a-2;l>k && ct < c;l--){
                list.add(matrix[l][k]);
                ct++;
            }
            k++;
            a--;
            b--;
        }
    return list;
    }
}
