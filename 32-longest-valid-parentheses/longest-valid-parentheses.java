class Solution {
    public class Pair{
        char c;
        int p;
        Pair(char c,int p){
            this.c=c;
            this.p=p;
        }
    }
    public int longestValidParentheses(String s) {
        Stack<Pair> st=new Stack<>();
        int n=s.length(),ans=0;
        st.push(new Pair(')',-1));
        for(int i=0;i<n;i++){
           if(s.charAt(i)=='('){
            st.add(new Pair('(',i));
           }
           else{
            if(!st.isEmpty() && st.pop().c=='('){
                  ans=Math.max(ans,i-st.peek().p); 
        
            }
            else{
                st.push(new Pair(')',i)); 
            }
           }
        }
        return ans;
    }
}