class Solution {
    public int minInsertions(String s) {
         Stack<Character> st=new Stack<>();
        int n=s.length();
        int ans=0, i=0;
        while(i<s.length()){
            if(s.charAt(i)=='('){
               
               st.push('('); 
               i++;             
            }
            else{
                int c=0;
                 while(i<n && s.charAt(i)==')' &&  c<2){
                    c++;
                    i++;
                 }
                if(st.isEmpty()){
                     if(c==2){
                        ans++;
                    }
                    if(c==1){
                        ans+=2;
                    }
                }
                else{
                    if(c==1){
                        ans+=1;
                    }
                    st.pop();
                }
            }
        
        }
        
        return ans+2*st.size();
    }
}