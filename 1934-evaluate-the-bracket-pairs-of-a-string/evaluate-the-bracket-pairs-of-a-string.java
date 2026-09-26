class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> hm=new HashMap<>();
        for(List<String> ls:knowledge){
            hm.put(ls.get(0),ls.get(1));   
        }
        boolean isOpen=false;
        StringBuilder str=new StringBuilder();;
        StringBuilder ans=new StringBuilder();
        for(char c:s.toCharArray()){
           if(c=='('){
            isOpen=true;
            str=new StringBuilder();
           }
           else if(c==')'){
            if(isOpen){
                if(hm.containsKey(str.toString())){
                    ans.append(hm.get(str.toString()));
                }
                else{
                    ans.append('?');
                }
            }
            isOpen=false;
           }
           else{
            if(!isOpen){
               ans.append(c);
            }
            else{
              str.append(c);
            }
           }
        }
        return ans.toString();
    }
}