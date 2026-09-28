class Solution {
    public int maxDepth(String s) {
        int res=0,ans=0;;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                   ans++;
                res=Math.max(res,ans);
             
            } 
            else if(s.charAt(i)==')' ) {
             ans--;
            } 
        }
           res=Math.max(res,ans);
    return res;
    }
   
}
