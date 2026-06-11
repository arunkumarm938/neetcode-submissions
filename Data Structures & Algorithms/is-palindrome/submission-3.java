class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = s.toCharArray();
        for(char c: charArr){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        String str = sb.toString();
        int i=0;
        i=(str.length()/2);
        int j=i;
        if((str.length()%2)==0){
            i=i-1;
        }
        while(i>=0 && j < str.length()){
            if(str.charAt(i)!=(str.charAt(j))){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
