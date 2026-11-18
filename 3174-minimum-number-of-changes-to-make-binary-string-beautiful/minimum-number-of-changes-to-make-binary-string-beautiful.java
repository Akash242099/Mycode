class Solution {
    public int minChanges(String s) {
        int n=s.length();
        int ans=0;
        for(int i=1;i<n;i+=2){
         
        char p=s.charAt(i);
        char q=s.charAt(i-1);
        if((p=='0' && q=='1') || (p=='1' && q=='0')){
          ans++;
        }
        }
        return ans;
    }
}