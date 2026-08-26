class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int[] freq=new int[2];
        int n=s.length(),j=0;
        int mini=Integer.MAX_VALUE;
        String ans="";
        for(int i=0;i<n;i++){
            int p=s.charAt(i)-'0';
            freq[p]++;
            while(freq[1]==k){
                int len=i-j+1;
              if(mini>len){
                ans=s.substring(j,i+1);
                mini=len;
              }
              else if(mini==len){
                if(s.substring(j,i+1).compareTo(ans)<0){
                    ans=s.substring(j,i+1);
                }
              }
               int q=s.charAt(j)-'0';
           
              if(q==1){
              freq[q]--;
              }
              j++;
            }
        }
        return ans;
    }
}