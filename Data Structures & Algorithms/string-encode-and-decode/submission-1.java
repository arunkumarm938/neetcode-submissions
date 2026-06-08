class Solution {

    String openDelimiter = "!AK";
    String closingDelimiter = "KA!";
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        sb.append(openDelimiter);
        for(int i=0;i<strs.size();i++){
            sb.append(strs.get(i).length());
            sb.append(closingDelimiter);
            sb.append(strs.get(i));
            if(i<strs.size()-1){
                sb.append(openDelimiter);
            }
            //System.out.println(sb.toString());
        }
        return sb.length()>3?sb.toString():new String();
        
    }

    public List<String> decode(String str) {
        if(str==null || str.length()==0){
            return new ArrayList<String>();
        }
        //System.out.println(str);
        List<String> op= new ArrayList<String>();
        for(int i=3;i<str.length();){
            StringBuilder len = new StringBuilder();
            //System.out.println(i+" as it is");
            while(str.charAt(i)!='K'){
                //System.out.println(str.charAt(i)+" len "+str.charAt(i));
                len.append(str.charAt(i++));
            }
            i+=3;
            //System.out.println(i+" i after processing");
            //System.out.println(len.toString()+" len as a string");
            Integer ilen = Integer.parseInt(len.toString());
            //System.out.println(ilen+" Ilen as an Int");
            //System.out.println(str.substring(i,i+ilen));
            op.add(str.substring(i,i+ilen));
            i+=ilen+3;
        }
        return op;
    }
}
