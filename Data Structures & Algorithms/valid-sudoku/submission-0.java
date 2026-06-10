class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<Integer, Set<Character>>();
        Map<Integer, Set<Character>> columnMap = new HashMap<Integer, Set<Character>>();
        Map<String, Set<Character>> squareMap = new HashMap<>();

        for(int i=0;i<9;i++){
            if(rowMap.get(i)==null){
                rowMap.put(i, new HashSet<Character>());
            }
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(columnMap.get(j)==null){
                        columnMap.put(j, new HashSet<Character>());
                    }
                    if(rowMap.get(i).contains(board[i][j])){
                        return false;
                    }else{
                        rowMap.get(i).add(board[i][j]);
                    }
                    if(columnMap.get(j).contains(board[i][j])){
                        return false;
                    }else{
                        columnMap.get(j).add(board[i][j]);
                    }
                    String square = (i/3)+","+(j/3);
                    if(squareMap.get(square)==null){
                        squareMap.put(square, new HashSet<Character>());
                    }
                    if(squareMap.get(square).contains(board[i][j])){
                        return false;
                    }else{
                        squareMap.get(square).add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }
}
