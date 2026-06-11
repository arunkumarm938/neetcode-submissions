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
        System.out.println(str);
        
        if((str.length()%2)==0){
            i=i-1;
        }
        System.out.println(str.length()+".   "+i+" "+j);
        while(i>=0 && j < str.length()){
            System.out.println(str.charAt(i)+".   "+str.charAt(j));
            if(str.charAt(i)!=(str.charAt(j))){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
